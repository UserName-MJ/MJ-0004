package cn.test.email.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.test.email.model.DataQuestion;
import cn.test.email.model.JsonData;
import cn.test.email.model.Label;
import cn.test.email.model.TQuestionVo;
import cn.test.email.model.TestlineData;
import cn.test.email.model.Users;
import cn.test.email.service.TuService;

@Controller
public class TuController {

	@Autowired
	private TuService statisticsService;
	
	
	@RequestMapping("showParper.do")
	public String showParper(HttpSession session,Model model){
		Users users = (Users) session.getAttribute("loginUser");
		List<Label> label = statisticsService.getLabel(users.getUid());
		model.addAttribute("label",label);
		return "abc";
	}
	
	@RequestMapping("/aaaa.do")
	@ResponseBody
	public List<TQuestionVo> aaa(Integer uid,HttpSession session){
		return statisticsService.getQuestion(uid);
	}
	
	@RequestMapping("/bbbb.do")
	@ResponseBody
	public List<TQuestionVo> bbbb(Integer uid,HttpSession session){
		List<TQuestionVo> questionLu = statisticsService.getQuestionLu(uid);
		return  questionLu;
	}

	@RequestMapping("/cccc.do")
	@ResponseBody
	public Object cccc(Integer uid,HttpSession session){
		List<DataQuestion> dataQuestion = statisticsService.getDataQuestion(uid);
		
		Integer[] data1 = new Integer[7];  
		Integer[] data2 = new Integer[7];  
		
		for(int i = 0;i<dataQuestion.size();i++){
			data1[i]=dataQuestion.get(i).getCount();
			data2[i]=dataQuestion.get(i).getCuo();
		}
	        JsonData jd1 = new JsonData();  
	        jd1.setName("总做题量");  
	        jd1.setData(data1);  
	          
	        JsonData jd2 = new JsonData();  
	        jd2.setName("错题");  
	        jd2.setData(data2);  
	          
	        List<JsonData> data = new ArrayList<JsonData>();  
	        data.add(jd1);  
	        data.add(jd2);  
	        
	        TestlineData tld = new TestlineData();  
	        tld.setData(data);
	        
		return  tld;
	}
	
	
}
