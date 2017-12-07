package cn.test.email.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.email.mapping.PaperHistoryMapper;
import cn.test.email.model.TPaperHistory;
import cn.test.email.service.PaperHistoryService;
@Service
public class PaperHistoryServiceImpl implements PaperHistoryService {

	@Autowired
	private PaperHistoryMapper paperHistoryMapper;
	@Override
	public void savePaper(TPaperHistory phistory) {
		phistory.setCreated(new Date());
		phistory.setGrading(1);
		paperHistoryMapper.savePaper(phistory);
		
	}

}
