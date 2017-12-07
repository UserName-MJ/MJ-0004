package cn.test.email.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.test.email.model.Label;
import cn.test.email.model.QuestionType;
import cn.test.email.service.LabelService;
import cn.test.email.service.QuestionsTypeService;
import cn.test.email.service.SaveQuestionService;

@Controller
public class SaveQuestionController {
	
	
	@Autowired
	private SaveQuestionService saveQuestionService;
	
	@Autowired
	private QuestionsTypeService questionsTypeService;
	@Autowired
	private LabelService labelService;
	
	/**
	 * 跳转页面
	 * @param model
	 * @param type
	 * @return
	 */
	@RequestMapping("xuanze.do")
	public String xueze(Model model, Integer type){
		model.addAttribute("type", type);
		return "xuanze";
	}
	
	@RequestMapping("/addExcle.do")
	public String addExcle(String type,Model model){
		/*
		 * 根据试题的类型跳转到不同的添加页面
		 */
		System.out.println(type);
	if(type!=null){
		if(type.equals("1")||type.equals("3")){
			model.addAttribute("type", type);
			return "myExcle";
		}else if(type.equals("2")){
			model.addAttribute("type", type);
			return "myExcle2";
		}
	}else{
		return "redirect:/toMyExam.do";
	}
		model.addAttribute("type", type);
		return "myExcle";
		
	}
	
	@RequestMapping("/luExcle.do")
	public String luExcle(MultipartFile filename,HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException, Exception{//qq392716797
		// 1、构造excel文件输入流对象  
		
		System.out.println("dddd");
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 允许设置内存中存储数据的门限，单位：字节
        factory.setSizeThreshold(4096);

        // 如果文件大小大于SizeThreshold，则保存到临时目录
        factory.setRepository(new File("E:\\"));
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 最大上传文件，单位：字节
        upload.setSizeMax(1000000);

        List fileItems = upload.parseRequest(request);
		Iterator iter = fileItems.iterator();

		if (iter.hasNext()) {
		    FileItem item = (FileItem) iter.next();
		    String fileName = item.getName();
		    // 忽略其他不是文件域的所有表单信息
		    if (!item.isFormField()) {
		            try {
		                //取得文件名
		                fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
		                System.out.println("我的filename："+fileName);
		                // 保存上传的文件到指定的目录指定文件名中
		                item.write(new File("E:\\",fileName));
		                saveQuestionService.jxExcle("E:\\"+fileName);
		            } catch (Exception e) {
		               
		            }
		    } 
		}
		return "redirect:/toMyExam.do";
	}
	
	
	/**
	 * 手动添加试题
	 */
	@RequestMapping("/shoudong.do")
	public String add(@RequestParam(defaultValue="1") Integer type, Model model, Integer id) {
	
		
		/**
		 * 查询试题类型
		 */
		List<QuestionType> questionsType = questionsTypeService.findQuestionsType();
		model.addAttribute("questionsType", questionsType);
		/**
		 * 查询试题标签
		 */
		List<Label> label = labelService.findLabel();
		model.addAttribute("label", label);

		/**
		 * 根据试题的类型跳转到不同的添加页面
		 */

		if(type!=null){
			if(type==1){
				model.addAttribute("type", type);
				model.addAttribute("id", id);
				return "my-question-A";
			}else if(type==2){
				model.addAttribute("type", type);
				model.addAttribute("id", id);
				return "my-question-B";
			}
		}else{
			return "redirect:/toMyExam.do";
		}
			model.addAttribute("type", type);
			model.addAttribute("id", id);
			
			return "my-question-C";
			
	}

}
