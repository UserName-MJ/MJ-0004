package cn.test.email.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import cn.test.email.exception.CustomException;
import cn.test.email.mapping.UsersMapper;
import cn.test.email.model.PageBean;
import cn.test.email.model.Users;
import cn.test.email.model.UsersVo;
import cn.test.email.service.IUserService;

@Service("IUserService")
public class IUserServiceImpl implements IUserService {

	@Autowired
	private UsersMapper usersMapper;
	
	@Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;

	public void insertUser(Users users) throws Exception {

		if (usersMapper.selectByPrimaryKey(users.getName()) != null) {
			throw new CustomException("该用户名已注册，请重新注册");
		}

		usersMapper.insertSelective(users);
	}

	public Users selectName(String name) throws Exception {

		Users user = usersMapper.selectByPrimaryKey(name);
		return user;
	}

	public Users selectUsers(Users user) throws Exception {
		Users u = usersMapper.selectByUsers(user);

		if (u == null) {
			throw new CustomException("登陆信息错误！");
		}

		return u;
	}

	/**
	 * 提升用的级别
	 */
	@Override
	public void updateRankDo(Users u) {
		// TODO Auto-generated method stub
		usersMapper.updateRank(u);
	}

	@Override
	public Users findUserByPhone(Users user) {
		/*
		 * UserExample example = new UserExample(); Criteria criteria =
		 * example.createCriteria(); criteria.andPhoneEqualTo(user.getPhone());
		 * List<User> userList = userMapper.selectByExample(example);
		 * if(userList.isEmpty()){ return null; } return userList.get(0);
		 */
		return usersMapper.selectByPrimaryKey(user.getName());
	}

	/**
	 * 查询所有学生
	 * 
	 * @return
	 */
	@Override
	public PageBean<Users> findStudentAll(Integer pageIndex,String uname) throws Exception {
		// TODO Auto-generated method stub
		// 创建分页实体类对象
		PageBean<Users> pb = new PageBean<Users>();
		pb.setPageNum(pageIndex);
		UsersVo uv=new UsersVo();
		uv.setPageCount(pb.getPageCount());
		uv.setDbBegin((pageIndex-1)*pb.getPageCount());
		uv.setUname(uname);
		//查询所有学生
	
		List<Users> list = usersMapper.findStudentAll(uv);
		
		//查询学生总数
		int studentCount = usersMapper.selectStudentCount(uv);
		pb.setTotalCount(studentCount);

		pb.setDataList(list);
		
		return pb;
	}
	 private void sendMessage(final String msg){
		    
	        jmsTemplate.send(new MessageCreator() {
	            public Message createMessage(Session session) throws JMSException {
	                return session.createTextMessage(msg);
	            }
	        });
	  }
	@Override
	public Map fa(String email, HttpSession session) {
		// TODO Auto-generated method stub
		String str = "";
		str += (int) (Math.random() * 9 + 1);//产生一位（1-10）
		for (int i = 0; i < 5; i++) {
			str += (int) (Math.random() * 10);//
		}
		String num = str;
		
		session.setAttribute("CODE", str);
		sendMessage(email+":"+str);
		Map map=new HashMap();
		map.put("status", 200);
		return map;
		
		
		
		
	}

}
