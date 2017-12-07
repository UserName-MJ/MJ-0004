package cn.test.email.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import cn.test.email.model.PageBean;
import cn.test.email.model.Users;

public interface IUserService {
	
	//注册用户
	public void insertUser(Users users) throws Exception;
	
	//检验用户表中是否存在相同的用户名
	public Users selectName(String name) throws Exception;
	
	//检验用户的用户名和密码是否正确
	public Users selectUsers(Users user) throws Exception;

	public void updateRankDo(Users u);

	public Users findUserByPhone(Users user);

	//查询所有学生
	public PageBean<Users> findStudentAll(Integer pageIndex,String uname) throws Exception;

	public Map fa(String email, HttpSession session);
	
	
	

}
