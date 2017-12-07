package cn.test.email.service;

import java.util.List;


import cn.test.email.model.TQuestion;

public interface AddQuestionService {

	void addQuestion(TQuestion tQuestion);

	List<TQuestion> findAll();

	void addQuestionVo(Integer[] qid, Integer pid);

	void saveQuestion(TQuestion tQuestion);

	void addPaperQuestion(TQuestion tQuestion);

}
