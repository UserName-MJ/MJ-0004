package cn.test.email.controller;

import java.util.HashMap;

import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.test.email.model.TPaperHistory;
import cn.test.email.model.TQuestionHistory;
import cn.test.email.service.PaperHistoryService;
import cn.test.email.service.QuestionHistoryService;
/**
 * 评分
 * @author AdminMcj
 *
 */
@Controller
@RequestMapping("/paper")
public class GradeController {

	@Autowired
	private QuestionHistoryService questionHistoryService;
	
	@Autowired
	private PaperHistoryService paperHistoryService;
	
	private Logger logger = Logger.getAnonymousLogger();
//	private static Logger log =Logger.getLogger(BankController.class);
	
	@RequestMapping("savepaper.do")
	public String savePaper(Integer pid,Integer uid,Integer[] qid,
		String[] uanswer,Integer[] state,Integer type,Model model){
		TQuestionHistory qhistory = new TQuestionHistory();
		qhistory.setUid(uid);
		qhistory.setPid(pid);
		for (int i = 0; i < qid.length; i++) {
			qhistory.setQid(qid[i]);
			qhistory.setUanswer(uanswer[i]);
			qhistory.setState(state[i]);
			questionHistoryService.saveQuestion(qhistory);
		}
		int count=0;
		for (int j = 0; j < state.length; j++) {
			if(state[j]==0){
				count++;
			}
		}
//		System.out.println("答对了："+count);
//		System.out.println("打错了："+(state.length-count));
		TPaperHistory phistory = new TPaperHistory();
		phistory.setPid(pid);
		phistory.setUid(uid);
		phistory.setTotalscore(100/state.length*count);
//		System.out.println("总分："+100/state.length*count);
		paperHistoryService.savePaper(phistory);
		
		model.addAttribute("totalnum", qid.length);
		model.addAttribute("count", count);
		model.addAttribute("totalscore", 100/state.length*count);
		return "gradeA";
	}
	
	/**
	 * 保存试题
	 * @param pid 试卷id
	 * @param uid 用户id
	 * @param qid 试题id
	 * @param uanswer 用户答案
	 * @param state 答题状态，true or false
	 * @param type 试题类型
	 * @param model
	 * @return
	 */
//	@RequestMapping("savepaper.do")
//	public String savePaper(Integer pid,Integer uid,Integer[] qid,
//			String[] uanswer,Integer[] state,Integer[] type,TPaperType paperType,Model model){
//		//添加试题历史表
//		TQuestionHistory qhistory = new TQuestionHistory();
//		qhistory.setUid(uid);
//		qhistory.setPid(pid);
//		for (int i = 0; i < qid.length; i++) {
//			qhistory.setQid(qid[i]);
//			qhistory.setUanswer(uanswer[i]);
//			qhistory.setState(state[i]);
//			questionHistoryService.saveQuestion(qhistory);
//		}
//		
//		//添加试卷历史表
//		TPaperHistoryVo phv = new TPaperHistoryVo();
//		phv.setPid(pid);
//		phv.setUid(uid);
//		for (int j = 0; j < type.length; j++) {
//			phv.setQid(qid[j]);
//			phv.setType(type[j]);
//			phv.setState(state[j]);
//		}	
//			//判断试题类型
//			int single = 0;//单选
//			int singlesum = 0;
//			int multiple = 0;//多选
//			int multiplesum = 0;
//			int gap = 0;//填空
//			int gapsum = 0;
//			int shortanswer = 0;//简答
//			int shortsum = 0;
//			if(phv.getType()!=null){
//				if(phv.getType()==1){
//					singlesum++;
//					if(phv.getState()==0){
//						single++;
//					}
//				}else if(phv.getType()==2){
//					multiplesum++;
//					if(phv.getState()==0){
//						multiple++;
//					}
//				}else if(phv.getType()==3){
//					gapsum++;
//					if(phv.getState()==0){
//						gap++;
//					}
//				}else if(phv.getType()==4){
//					shortsum++;
//					if(phv.getState()==0){
//						shortanswer++;
//					}
//				}else{
//					logger.info("评分没有此类型试题");
//				}
//			}
//			int testcount = singlesum+multiplesum+gapsum+shortsum;//总题数
//			int count = single+multiple+gap+shortanswer;//答对总题数
//			System.out.println(count);
//			
//			//判断各项得分
//			int singlesc = 0;//单选得分
//			int multiplesc = 0;//多选得分
//			int gapsc = 0;//填空得分
//			int shortsc = 0;//简答得分
//			if(paperType.getTid()!=null){
//				if(paperType.getTid()==1){
//					singlesc=paperType.getMinute()/singlesum*single;
//				}
//				else if(paperType.getTid()==2){
//					multiplesc=paperType.getMinute()/multiplesum*multiple;
//				}
//				else if(paperType.getTid()==3){
//					gapsc=paperType.getMinute()/gapsum*gap;
//				}
//				else if(paperType.getTid()==4){
//					shortsc=paperType.getMinute()/shortsum*shortanswer;
//				}
//				else{
//					logger.info("没有此类型试题分数");
//				}
//			}
//			//计算总分数
//			int totalscore = singlesc+multiplesc+gapsc+shortsc;
//			
////			String detailScore = "单选题："+singlesc+",多选题："+multiplesc+",填空题："+gapsc+",简答题："+shortsc;
//			Map<String, Integer> map = new HashMap<String,Integer>();
//			map.put("单选", singlesc);
//			map.put("多选", multiplesc);
//			map.put("填空", gapsc);
//			map.put("简答", shortsc);
//			String json = JsonUtils.objectToJson(map);
//			
//			TPaperHistory paperHistory = new TPaperHistory();
//			paperHistory.setUid(uid);
//			paperHistory.setPid(pid);
//			paperHistory.setTotalscore(totalscore);
//			paperHistory.setDetailscore(json);
//			paperHistoryService.savePaper(paperHistory);
//		
//		return "";
//	}
}
