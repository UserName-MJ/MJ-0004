package cn.test.email.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.test.email.model.Shouvo;
import cn.test.email.model.TExamQuestion;
import cn.test.email.model.TestPaper;
import cn.test.email.service.AddTiService;



@Controller
public class AddTiController {
	@Autowired
    private AddTiService addTiService;
	@RequestMapping("/addti")
	public String addti(String name,String shi) throws UnsupportedEncodingException{
		//name=URLEncoder.encode(name, "utf-8");
		//shi=URLEncoder.encode(shi, "utf-8");
		name=new String(name.getBytes("ISO-8859-1"), "utf-8");
		shi=new String(shi.getBytes("ISO-8859-1"), "utf-8");
		TestPaper testPaper=addTiService.addti(name,shi);
		return "redirect:/toshou.do";
		
	}
	@RequestMapping("toshou.do")
	public String cha(Model model){
		List<TestPaper> testPaper=addTiService.cha();
		model.addAttribute("testPaper", testPaper);
		return "my-test-paper";
	}
	/*
	 * 预览试卷
	 */
	@RequestMapping("yl.do")
	public String yl(Integer id,Model model,String time,String pname) throws UnsupportedEncodingException{
		List<TExamQuestion> list = addTiService.yl(id);
		
		pname=new String(pname.getBytes("ISO-8859-1"), "utf-8");
		time=new String(time.getBytes("ISO-8859-1"), "utf-8");
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
		/*model.addAttribute("list", time);
		model.addAttribute("list", list);*/
		return "my-exam";
	
		
		
	}
	/*
	 * 一键生成试卷
	 */
	@SuppressWarnings({ "unused", "unused" })
	@RequestMapping("/sc.do")
	public String sc(String name,String shi) throws UnsupportedEncodingException{
		//name=URLEncoder.encode(name, "utf-8");
		//shi=URLEncoder.encode(shi, "utf-8");
		name=new String(name.getBytes("ISO-8859-1"), "utf-8");
		shi=new String(shi.getBytes("ISO-8859-1"), "utf-8");
		int j = addTiService.addyi(name,shi);
		System.out.println(j);
		List<TExamQuestion> dan=addTiService.finddan();
		List<TExamQuestion> duo=addTiService.findduo();
		List<TExamQuestion> tian=addTiService.findtian();
		List<TExamQuestion> jian=addTiService.findjian();
		
		List<TExamQuestion> list=new ArrayList<TExamQuestion>();
		List<TExamQuestion> list1=new ArrayList<TExamQuestion>();
		List<TExamQuestion> list2=new ArrayList<TExamQuestion>();
		List<TExamQuestion> list3=new ArrayList<TExamQuestion>();
		if(dan!=null){
			Collections.shuffle(dan);
			for (TExamQuestion tExamQuestion : dan) {
				//int type = Integer.parseInt(tExamQuestion.getType());
				if(list.size()>=2){
					break;
				}
				list.add(tExamQuestion);
			}
			
		}
		if(duo!=null){
			Collections.shuffle(duo);
			for (TExamQuestion tExamQuestion : duo) {
				//int type = Integer.parseInt(tExamQuestion.getType());
				if(list1.size()>=2){
					break;
				}
				list1.add(tExamQuestion);
			}
			
		}
		if(tian!=null){
			Collections.shuffle(tian);
			for (TExamQuestion tExamQuestion : tian) {
				//int type = Integer.parseInt(tExamQuestion.getType());
				if(list2.size()>=1){
					break;
				}
				list2.add(tExamQuestion);
			}
			
		}
		if(jian!=null){
			Collections.shuffle(jian);
			for (TExamQuestion tExamQuestion : jian) {
				int type = Integer.parseInt(tExamQuestion.getType());
				if(list3.size()>=1){
					break;
				}
				list3.add(tExamQuestion);
			}
			
		}
		
		/*List<List<TExamQuestion>> list4=new ArrayList<List<TExamQuestion>>();
		list4.add(list);
		list4.add(list1);
		list4.add(list2);
		list4.add(list3);*/
		
		for (TExamQuestion tExamQuestion : list) {
			//int i = Integer.parseInt(tExamQuestion.getType());
			int i=tExamQuestion.getId();
			addTiService.adddan(j,i);
		}
		for (TExamQuestion tExamQuestion : list1) {
			//int i1 = Integer.parseInt(tExamQuestion.getType());
			int i1=tExamQuestion.getId();
			addTiService.addduo(j,i1);
		}
		for (TExamQuestion tExamQuestion : list2) {
			//int i2 = Integer.parseInt(tExamQuestion.getType());
			int i2=tExamQuestion.getId();
			addTiService.addtian(j,i2);
		}
		for (TExamQuestion tExamQuestion : list3) {
			//int i3 = Integer.parseInt(tExamQuestion.getType());
			int i3=tExamQuestion.getId();
			addTiService.addjian(j,i3);
		}
		/*List<Integer> l=new ArrayList<Integer>();*/
		
		
		
		return "redirect:/toshou.do";
		
	}
}
