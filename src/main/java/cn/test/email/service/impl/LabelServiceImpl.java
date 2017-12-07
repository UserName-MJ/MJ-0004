package cn.test.email.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.email.mapping.LabelMapper;
import cn.test.email.model.Label;
import cn.test.email.service.LabelService;
@Service
public class LabelServiceImpl implements LabelService {
	
	@Autowired
	private LabelMapper labelMapper;
	

	@Override
	public List<Label> findLabel() {
		// TODO Auto-generated method stub
		return labelMapper.findLabel();
	}

}
