package cn.test.email.mapping;

import java.util.List;

import cn.test.email.model.Users;
import cn.test.email.model.UsersVo;

public interface UsersMapper {
	
    int deleteByPrimaryKey(String name);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
    Users selectByUsers(Users user);

	void updateRank(Users u);

	List<Users> findStudentAll(UsersVo uv) throws Exception;

	int selectStudentCount(UsersVo uv);
}