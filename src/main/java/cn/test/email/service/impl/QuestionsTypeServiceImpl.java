package cn.test.email.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.email.mapping.QuestionsTypeMapper;
import cn.test.email.model.QuestionType;
import cn.test.email.service.QuestionsTypeService;

@Service
public class QuestionsTypeServiceImpl implements QuestionsTypeService{

	@Autowired
	private QuestionsTypeMapper questionTypemapper;
	
	@Override
	public List<QuestionType> findQuestionsType() {
		// TODO Auto-generated method stub
		return questionTypemapper.findQuestionsType();
	}

}
