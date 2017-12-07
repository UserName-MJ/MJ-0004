package cn.test.email.mapping;

import java.util.List;


import cn.test.email.model.TQuestion;

public interface AddQuestionMapper {

	void addQuestion(TQuestion tQuestion);

	List<TQuestion> findAll();

	void addPaperQuestion(TQuestion tq);

	void saveQuestion(TQuestion tQuestion);

	void addExam(TQuestion exam);


}
