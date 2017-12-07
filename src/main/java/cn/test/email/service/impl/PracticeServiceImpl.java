package cn.test.email.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.email.model.Condition;
import cn.test.email.model.Label;
import cn.test.email.model.TQuestion;
import cn.test.email.mapping.PracticeMapper;
import cn.test.email.service.PracticeService;
@Service
public class PracticeServiceImpl implements PracticeService{

	@Autowired
	private PracticeMapper practiceMapper;
	
	@Override
	public List<Label> findLabel() {
		// TODO Auto-generated method stub
		return practiceMapper.findLabel();
	}

	@Override
	public List<TQuestion> findQuestionAll() {
		// TODO Auto-generated method stub
		return practiceMapper.findQuestionAll();
	}


	@Override
	public List<TQuestion> findQuestionByCondition(Condition condition) {
		// TODO Auto-generated method stub
		return practiceMapper.findQuestionByCondition(condition);
	}

}
