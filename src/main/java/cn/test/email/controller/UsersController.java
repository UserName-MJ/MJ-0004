package cn.test.email.controller;



import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.test.email.model.PageBean;
import cn.test.email.model.Users;
import cn.test.email.service.IUserService;

@Controller
@RequestMapping("/user")
public class UsersController {
	
	@Autowired
	private IUserService iUserService;
	
	//private Logger log=Logger.getAnonymousLogger();
	
	@RequestMapping("/dologin")
	public String doLogin(Users user,HttpSession session,HttpServletRequest request) throws Exception{
		Users u=iUserService.selectUsers(user);
		session.setAttribute("loginUser", u);
	
		if(u.getRank()==0){
			//如果是管理员就跳转到管理页面
			return "redirect:/toMyExam.do";
		}
		//用户跳转到用户考试页面
		return "redirect:/toUserExam.do?rank="+u.getRank();
	}
	
	@RequestMapping("/doregister")
	public String doRegister(Model model,@Validated Users user,BindingResult bindingResult) throws Exception{
		
		if (bindingResult.hasErrors()) {
			// 输出错误信息
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			// 将错误信息传到页面
			model.addAttribute("allErrors", allErrors);
			
			
			return "register";
		}
		user.setRank(1);
		iUserService.insertUser(user);
		
		return "login";
		
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/register")
	public String register(){
		
		return "register";
	}
	
	
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session) throws Exception{
		
		session.invalidate();
		return "login";
		
	}

	
	/**
	 * 提升用户级别
	 */
	@RequestMapping("/updateRankDo.do")
	public String updateRankDo(HttpSession session){
		Users u = (Users) session.getAttribute("loginUser");
		Integer rank = u.getRank();
		rank=rank+1;
		u.setRank(rank);
		iUserService.updateRankDo(u);
		session.setAttribute("msg","用户级别已提升，请重新登陆！");
		return "redirect:/user/login.do";
	}
	
	
	@RequestMapping("/registerFindUser")
	public void registerFindUser(Users user,HttpServletResponse response,HttpSession session) throws Exception {
		Users u = iUserService.findUserByPhone(user);
		String code=(String)session.getAttribute("CODE");
		PrintWriter out = response.getWriter();
		if(code.equals(user.getCode())){
			if (u==null) {
			out.print("success");
			return;
		}else{
		out.print("field");
		return;
		}
		}else{
			out.print("yz");
		}
	}
	
	@RequestMapping("/home")
	public String home(){
		
		return "homepage";
	}
	
	/**
	 * 查看所有学生
	 *
	 */
	@RequestMapping("/findStudentAll.do")
	public String findStudentAll(Model m,@RequestParam(defaultValue="1") Integer pageIndex,String uname) throws Exception {
		PageBean<Users> list = iUserService.findStudentAll(pageIndex,uname);
		
		m.addAttribute("pb", list);
		m.addAttribute("na", uname);
		return "my-test-student";
	}
	
	@RequestMapping("/fa.do")
	@ResponseBody
	public Map fa(String email,HttpSession session){
		System.out.println("1111");
		  return iUserService.fa(email,session);
		
	}
	
	@RequestMapping("/tuichu.do")
	public String tuichu(HttpSession session){
		session.invalidate();
		return "redirect:/user/login.do";
	}
	
}
