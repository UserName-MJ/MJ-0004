package cn.test.email.mapping;

import java.util.List;

import cn.test.email.model.DataQuestion;
import cn.test.email.model.Label;
import cn.test.email.model.Users;

public interface TuMapper {
	
	public List<Label> getQuestionType(Integer uid);

	public List<Label> getErrorCount(Users users);

	public int getQuestionCount(Integer lid);
	
	public int getQuestionCountZheng(Integer lid);

	public int getLabel();

	public int getZongCount(DataQuestion dq);
	
	public int getErrorCount(DataQuestion dq);

}
