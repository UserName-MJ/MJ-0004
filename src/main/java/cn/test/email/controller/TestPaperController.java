package cn.test.email.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.test.email.model.SeedPaper;
import cn.test.email.model.Shouvo;
import cn.test.email.model.TExamQuestion;
import cn.test.email.model.TestPaper;
import cn.test.email.service.AddTiService;
import cn.test.email.service.TestPaperService;

@Controller
public class TestPaperController {

	@Autowired
	private TestPaperService testPaperService;
	@Autowired
    private AddTiService addTiService;

	private Logger logger = Logger.getAnonymousLogger();

	/**
	 * 管理页面 跳转到我的试卷页面 查询出所有的试卷 以及子卷
	 */
	@RequestMapping("/toMyExam.do")
	public String toMyExam(Model model, SeedPaper sp) {
		List<TestPaper> testPaper = null;
		try {
			testPaper = testPaperService.selectAllTestPaper(sp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("查询试卷失败！");
		}
		if (testPaper != null) {
			model.addAttribute("testPaper", testPaper);
		}

		List<SeedPaper> seedPaper = null;
		try {
			seedPaper = testPaperService.selectSeedPaper(sp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("查询子卷失败！");
		}
		if (seedPaper != null) {
			model.addAttribute("seedPaper", seedPaper);
		}
		
		
		return "my-test-paper";
	}

	/***
	 * 跳转到用户页面
	 */
	@RequestMapping("/toUserExam.do")
	public String toUserExam(Model model, Integer rank) {

		List<TestPaper> testPaper = null;
		try {
			testPaper = testPaperService.selectTestPaperById(rank);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("查询试卷失败！");
		}
		if (testPaper != null) {
			model.addAttribute("testPaper", testPaper);
		}
		return "userExam";
	}

	/***
	 * 跳转到评分做题页面
	 * @throws Exception 
	 */
	@RequestMapping("/myExam.do")
	public String myExam(Integer id, Model model,String time,String pname) {
		List<TExamQuestion> list = addTiService.yl(id);
		
		Shouvo s=null;
		if(list.size()>0&&list!=null){
			s=new Shouvo();
			s.setL(list);
			s.setPname(pname);
			s.setTime(time);
			
		for (TExamQuestion tExamQuestion : list) {
			String option = tExamQuestion.get_option();
			if(option!=null){
				
				String[] split = option.split(",");
				List<String> ops =tExamQuestion.getOps();
				for (int i = 0; i < split.length; i++) {
					ops.add(split[i]);
				}
			}
		  }
		}
	    model.addAttribute("list", s);
	    model.addAttribute("pid", id);
		return "my-examA";
	}

	/**
	 * 跳转到新建试卷页面
	 */
	@RequestMapping("/addTestPaper.do")
	public String addTestPaper() {
		return "addTestPaper";
	}

	/**
	 * 添加试卷
	 */
	@RequestMapping("/addTestPaperDo.do")
	public String addTestPaperDo(TestPaper testPaper) {
		try {
			testPaperService.addTestPaper(testPaper);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("试卷添加失败！");
		}
		return "redirect:/toMyExam.do";
	}

	/**
	 * 跳转到添加子卷页面
	 */
	@RequestMapping("/addSeedPaper.do")
	public String addSeedPaper(Integer id, Model model) {
		model.addAttribute("id", id);
		return "addSeedPaper";

	}

	/**
	 * 添加子卷
	 */
	@RequestMapping("/addSeedPaperDo.do")
	public String addSeedPaperDO(SeedPaper seedPaper) {
		testPaperService.addSeedPaper(seedPaper);
		return "redirect:/toMyExam.do";
	}

	

}
