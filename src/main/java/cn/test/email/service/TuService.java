package cn.test.email.service;

import java.util.List;

import cn.test.email.model.DataQuestion;
import cn.test.email.model.Label;
import cn.test.email.model.TQuestionVo;

public interface TuService {
	
	public List<TQuestionVo> getQuestion(Integer uid);

	public List<TQuestionVo> getQuestionLu(Integer uid);

	public List<DataQuestion> getDataQuestion(Integer uid);

	public List<Label> getLabel(Integer uid);
	

}
