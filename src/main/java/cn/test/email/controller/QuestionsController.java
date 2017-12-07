package cn.test.email.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.test.email.jedis.JedisClientPool;
import cn.test.email.model.Label;
import cn.test.email.model.QuestionType;
import cn.test.email.model.TQuestion;
import cn.test.email.model.Users;
import cn.test.email.service.AddQuestionService;
import cn.test.email.service.LabelService;
import cn.test.email.service.QuestionsTypeService;
import cn.test.email.utils.JsonUtils;

@Controller
public class QuestionsController {

	@Autowired
	private QuestionsTypeService questionsTypeService;
	@Autowired
	private LabelService labelService;

	@Autowired
	private AddQuestionService addQuestionService;

	private Logger logger = Logger.getAnonymousLogger();

	/**
	 * 跳转到添加试题页面
	 * 
	 * @return
	 */
	@RequestMapping("/add.do")
	public String add(String type, Model model, Integer id) {
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

		model.addAttribute("type", type);
		model.addAttribute("pid", id);
		return "my-question-bank";

	}

	/**
	 * 从题库中选题添加 从数据库查询所有试题
	 */
	@RequestMapping("/selectquestions.do")
	public String selectquestions(Integer id, Model model) {
		model.addAttribute("pid", id);
		List<TQuestion> list = addQuestionService.findAll();
		model.addAttribute("questionlist", list);

		return "examCore";
	}

	/**
	 * 从数据库中选题添加 试题添加到试卷
	 */
	@RequestMapping("/selectAdd.do")
	public String selectquestionsAdd(Integer[] qid, Integer pid) {

		addQuestionService.addQuestionVo(qid, pid);
		return "redirect:/toMyExam.do";
	}

	/**
	 * 添加题 到缓存
	 */
	@RequestMapping("/addQuestion.do")
	@ResponseBody
	public TQuestion add(TQuestion tQuestion, String[] options, HttpSession session) {
        System.out.println(tQuestion.getType());
		Users u = (Users) session.getAttribute("loginUser");
		JedisClientPool jedis = new JedisClientPool();

		List<TQuestion> list = null;
		String s1 = jedis.hget(u.getUid() + "USER", tQuestion.getType() + "QUESTION");

		if (s1 != null && !StringUtils.isBlank(s1)) {

			if (options != null && options.length > 1) {
				String st = "";
				for (int i = 0; i < options.length; i++) {
					st += options[i] + ",";
				}
				tQuestion.set_option(st);
			} else if (options != null && options.length == 1) {
				tQuestion.set_option(options[0]);
			}
			tQuestion.setCreated(new Date());
			list = JsonUtils.jsonToList(s1, TQuestion.class);
			list.add(tQuestion);
			String str = JsonUtils.objectToJson(list);
			jedis.hset(u.getUid() + "USER", tQuestion.getType() + "QUESTION", str);
		} else {
			tQuestion.setCreated(new Date());
			if (options != null && options.length > 1) {
				String st = "";
				for (int i = 0; i < options.length; i++) {
					st += options[i] + ",";
				}
				tQuestion.set_option(st);
			} else if (options != null && options.length == 1) {
				tQuestion.set_option(options[0]);
			}

			list = new ArrayList<TQuestion>();
			list.add(tQuestion);
			String str = JsonUtils.objectToJson(list);
			jedis.hset(u.getUid() + "USER", tQuestion.getType() + "QUESTION", str);
			// session.setAttribute(tQuestion.getType()+"QUESTION",str);

		}

		return tQuestion;
	}

	/**
	 * 把缓存中试题保存到数据库
	 */
	@RequestMapping("/saveQuestion.do")
	public String save(Integer pid, HttpSession session) {
		System.out.println("ssssssssss");
		Users u = (Users) session.getAttribute("loginUser");
		JedisClientPool jedis = new JedisClientPool();

		Map<String, String> hgetAll = jedis.hgetAll(u.getUid() + "USER");
		Set<String> set = hgetAll.keySet();
		for (String str : set) {
			List<TQuestion> list = JsonUtils.jsonToList(hgetAll.get(str), TQuestion.class);
			for (TQuestion tQuestion : list) {

				System.out.println(tQuestion.toString());
				addQuestionService.saveQuestion(tQuestion);
				tQuestion.setPid(pid);
				addQuestionService.addPaperQuestion(tQuestion);
			}
			/**
			 * 清空缓存
			 */
			jedis.hdel(u.getUid() + "USER", str);
		}

		return "redirect:/toMyExam.do";
	}

	/**
	 * 退出清空缓存
	 */

	@RequestMapping("/quit.do")
	public String quit(HttpSession session) {
		Users u = (Users) session.getAttribute("loginUser");
		JedisClientPool jedis = new JedisClientPool();
		Map<String, String> hgetAll = jedis.hgetAll(u.getUid() + "USER");
		Set<String> set = hgetAll.keySet();
		for (String str : set) {
			jedis.hdel(u.getUid() + "USER", str);

		}
		return "redirect:/toMyExam.do";
	}

	/**
	 * 
	 * 从redis删除试题
	 */
	@RequestMapping("/deleteQuestion.do")
	@ResponseBody
	public String  deleteQuestion(String title, HttpSession session, String type) {
	
		Users u = (Users) session.getAttribute("loginUser");
		JedisClientPool jedis = new JedisClientPool();

		String str = jedis.hget(u.getUid() + "USER", type + "QUESTION");
		List<TQuestion> list = JsonUtils.jsonToList(str, TQuestion.class);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().equals(title)) {
				list.remove(i);
			}
		}
		
		String json = JsonUtils.objectToJson(list);
		jedis.hset(u.getUid() + "USER", type + "QUESTION",json);
		return title;
	}

}
