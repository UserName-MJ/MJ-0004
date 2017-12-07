package cn.test.email.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.email.mapping.TuMapper;
import cn.test.email.model.DataQuestion;
import cn.test.email.model.Label;
import cn.test.email.model.TQuestionVo;
import cn.test.email.service.TuService;

@Service
public class TuServiceImpl implements TuService {
	
	@Autowired
	private TuMapper statisticsMapper;

	@Override
	public List<TQuestionVo> getQuestion(Integer uid) {
		// TODO Auto-generated method stub
		List<Label> qt = statisticsMapper.getQuestionType(uid);
		
		List<TQuestionVo> list = new ArrayList<TQuestionVo>();
		for (Label q : qt) {
			TQuestionVo qe = new TQuestionVo();
			qe.setLid(q.getLid());
			qe.setLname(q.getLabel());
			qe.setlCount(statisticsMapper.getQuestionCount(q.getLid()));
			list.add(qe);
		}
		return list;
	}

	@Override
	public List<TQuestionVo> getQuestionLu(Integer uid) {
		// TODO Auto-generated method stub
		
		List<Label> qt = statisticsMapper.getQuestionType(uid);
		
		int label = statisticsMapper.getLabel();
		List<TQuestionVo> list = new ArrayList<TQuestionVo>();
		int i = 1;
		boolean b = false;
		boolean c = true;
		while(i<=label){
			System.out.println(i);
			TQuestionVo qe = new TQuestionVo();
			for (Label q : qt) {
				if(q.getLid()==i){
					qe.setLid(q.getLid());
					int count = statisticsMapper.getQuestionCount(q.getLid());//总题数
					int zheng = statisticsMapper.getQuestionCountZheng(q.getLid());//正确的题的数
					int lu = (int) (((zheng*0.1)/(count*0.1))*100);//正确率  
					qe.setLu(lu);
					b = true;
					c = false;
					break;
				}
			}
			if(c){
				System.out.println("fvvd omlk");
				qe.setLid(i);
				qe.setLu(0);
				System.out.println(qe);
				b = true;
			}
			if(b){
				list.add(qe);
				c = true;
				i++;
			}
		}
		return list;
	}

	@Override
	public List<DataQuestion> getDataQuestion(Integer uid) {
		// TODO Auto-generated method stub
		List<DataQuestion> list = new ArrayList<DataQuestion>();
		
		for (int i = 7; i >0; i--) {
			DataQuestion dq = new DataQuestion();
				dq.setUid(uid);
				
				Date dBefore = new Date();

				Calendar calendar = Calendar.getInstance(); //得到日历
				//calendar.setTime(dNow);//把当前时间赋给日历
				calendar.add(Calendar.DAY_OF_MONTH, -i);  //设置为前一天
				dBefore = calendar.getTime();   //得到前一天的时间
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
				String defaultStartDate = sdf.format(dBefore);    //格式化前一天
				//String defaultEndDate = sdf.format(dNow); //格式化当前时间
				
				dq.setDatatime(defaultStartDate);
				
				int zongCount = statisticsMapper.getZongCount(dq);
				dq.setCount(zongCount);
				int errorCount = statisticsMapper.getErrorCount(dq);
				dq.setCuo(errorCount);
				list.add(dq);
		}
		for (DataQuestion dataQuestion : list) {
			System.out.println(dataQuestion);
		}
		return list;
	}

	@Override
	public List<Label> getLabel(Integer uid) {
		// TODO Auto-generated method stub
		return statisticsMapper.getQuestionType(uid);
	}


}
