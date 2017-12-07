package cn.test.email.service;

import java.util.List;

import cn.test.email.model.Condition;
import cn.test.email.model.Label;
import cn.test.email.model.TQuestion;
public interface PracticeService {

	List<Label> findLabel();

	List<TQuestion> findQuestionAll();

	List<TQuestion> findQuestionByCondition(Condition condition);

}
