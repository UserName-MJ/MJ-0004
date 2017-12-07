package cn.test.email.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import cn.test.email.model.Condition;
import cn.test.email.model.Label;
import cn.test.email.model.TQuestion;
import cn.test.email.service.PracticeService;

@Controller
public class PracticeController {

	@Autowired
	private PracticeService practiceService;
	
	
	/**
	 * 跳转至专题练习菜单页面
 	 * @date 2017年11月24日 下午3:01:39
	 * @return
	 */
	@RequestMapping("/toMenu.do")
	public String toMenu(Model model,HttpSession session){
		
		List<Label>  labelList =  practiceService.findLabel();
		
		session.setAttribute("labelList",labelList);//model.addAttribute("labelList",labelList);
		
		return "menu";
		
	}
	
	/**
	 * 根据专题练习条件查找相应的题目
	 * @author LuyaoW
	 * @date 2017年11月25日 下午2:26:59
	 * @param labels
	 * @param rank
	 * @param type
	 * @return
	 */
	@RequestMapping("/findQuestionsByCondition.do")
	public String findQuestionsByCondition(HttpSession session,
			String[] labels,Integer rank,Integer[] types,Model model){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i <types.length; i++){
			if(i!=types.length-1){
				sb.append(types[i]+",");
			}else{
				sb.append(types[i]);
			}
		}
		String type= sb.toString();
		Condition condition = new Condition();
		List<TQuestion> questionList = new ArrayList<TQuestion>();
		for (String label : labels) {
			condition.setLabel(label);
			condition.setRank(rank);
			condition.setType(type);
			List<TQuestion> list  = practiceService.findQuestionByCondition(condition);
			for (TQuestion TQuestion : list) {
				questionList.add(TQuestion);
			}
		}
		List<String> aaa = new ArrayList<String>();
		for (TQuestion TQuestion : questionList) {
			aaa.add(TQuestion.getAnswer());
			String _option = TQuestion.get_option();
			String[] strings = _option.split(",");
			List<String> options = new ArrayList<String>();
			for (String string : strings) {
				options.add(string);
			}
			TQuestion.setOps(options);
		}
		session.setAttribute("aaa",aaa);
		session.setAttribute("length",questionList.size());
		model.addAttribute("list",questionList);
		return "question";
	}
	
	@RequestMapping("toQuestion.do")
	public String toQuestion(){

		return "question";
	
	}
	
	List<String> answerList = new ArrayList<String>();
	/**
	 * 交卷评分
	 * @author LuyaoW
	 * @date 2017年11月28日 上午9:34:11
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("handInPaper.do")
	public String handInPaper(String sth,String[] answers,HttpSession session,HttpServletRequest request,
			@RequestParam(defaultValue="aaa")String answer,HttpServletResponse response) throws IOException{
		if(sth!=null && sth!=""){
				
				answerList.add(sth);
			}
			if(answers!=null){
				
				for (String ans : answers) {
					answerList.add(ans);
				}
			}
			answerList.remove("");
			answerList.remove(null);
			
		List<String> list= new ArrayList<String>();
		for (String sss : answerList) {
			char[] ca=sss.toCharArray();
			sss="";
			for (int i = 0; i < ca.length; i++) {
				if(ca[i]=='1'){
					sss+='A';
				}
				if(ca[i]=='2'){
					sss+='B';
				}
				if(ca[i]=='3'){
					sss+='C';
				}
				if(ca[i]=='4'){
					sss+='D';
				}
			}
			System.out.println(sss);
			list.add(sss);
		}
		list.remove(null);
		list.remove("");
		List<String> aaa = (List<String>) session.getAttribute("aaa");
		
		Integer count = 0;
		for (int i = 0; i < aaa.size()-1; i++) {
			for (int j = 0; j < list.size()-1; j++) {
				if(i==j){
					if(aaa.get(i).equals(list.get(i))){
						count+=1;
					}
				}
			}
		}
		request.setAttribute("count",count);
		response.getWriter().write("你来了");
		if(list!=null){
			list.clear();
		}
		return "grade";
	}
}
