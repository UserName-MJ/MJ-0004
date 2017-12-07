package cn.test.email.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.email.mapping.QuestionHistoryMapper;
import cn.test.email.model.TQuestionHistory;
import cn.test.email.service.QuestionHistoryService;
@Service
public class QuestionHistoryServiceImpl implements QuestionHistoryService {

	@Autowired
	private QuestionHistoryMapper questionHistoryMapper;
	
	@Override
	public void saveQuestion(TQuestionHistory qhistory) {
		qhistory.setCreated(new Date());
		questionHistoryMapper.saveQuestion(qhistory);

	}

}
