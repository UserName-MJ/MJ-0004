package cn.test.email.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.email.mapping.AddTiMapper;
import cn.test.email.model.TExamQuestion;
import cn.test.email.model.TestPaper;
import cn.test.email.model.idvo;
import cn.test.email.model.yivo;
import cn.test.email.service.AddTiService;
@Service
public class AddTiServiceImpl implements AddTiService{
	@Autowired
    private AddTiMapper addTiMapper;
	@Override
	public TestPaper addti(String name, String shi) {
		// TODO Auto-generated method stub
		TestPaper testPaper=new TestPaper();
		testPaper.setTime(shi);
		testPaper.setPname(name);
		testPaper.setQnum(6);
		testPaper.setMinute(100);
		addTiMapper.addti(testPaper);
		return testPaper;
	}
	@Override
	public List<TestPaper> cha() {
		// TODO Auto-generated method stub
		return addTiMapper.cha();
	}
	@Override
	public List<TExamQuestion> yl(Integer id) {
		// TODO Auto-generated method stub
		//根据id查询t_paper_question表查出试题的id
		 List<TExamQuestion> list=null;
		 idvo dvo=new idvo();
		 List<Integer> selectpid = addTiMapper.selectpid(id);
		 for (Integer integer : selectpid) {
			System.out.println(integer.toString());
		}
		 if(selectpid!=null && selectpid.size()>0){
			 List<Integer> chaid = addTiMapper.chaid(id);
			 dvo.setList(chaid);
			 list= addTiMapper.selectti(dvo);
		 }
		 return list;
		 
		
	}
	@Override
	public List<TExamQuestion> finddan() {
		
		// TODO Auto-generated method stub
		return addTiMapper.finddan();
	}
	@Override
	public List<TExamQuestion> findduo() {
		// TODO Auto-generated method stub
		return addTiMapper.findduo();
	}
	@Override
	public List<TExamQuestion> findtian() {
		// TODO Auto-generated method stub
		return addTiMapper.findtian();
	}
	@Override
	public List<TExamQuestion> findjian() {
		// TODO Auto-generated method stub
		return addTiMapper.findjian();
	}
	@Override
	public void adddan(int j,int i) {
		// TODO Auto-generated method stub
		yivo y=new yivo();
		y.setJ(j);
		y.setI(i);
		addTiMapper.adddan(y);
	}
	@Override
	public void addduo(int j,int i1) {
		// TODO Auto-generated method stub
		yivo y=new yivo();
		y.setJ(j);
		y.setI(i1);
		addTiMapper.addduo(y);
	}
	@Override
	public void addtian(int j,int i2) {
		// TODO Auto-generated method stub
		yivo y=new yivo();
		y.setJ(j);
		y.setI(i2);
		addTiMapper.addtian(y);
	}
	@Override
	public void addjian(int j,int i3) {
		// TODO Auto-generated method stub
		yivo y=new yivo();
		y.setJ(j);
		y.setI(i3);
		addTiMapper.addjian(y);
	}
	@Override
	public int addyi(String name, String shi) {
		// TODO Auto-generated method stub
		TestPaper testPaper=new TestPaper();
		testPaper.setTime(shi);
		testPaper.setPname(name);
		testPaper.setQnum(6);
		testPaper.setMinute(100);
		addTiMapper.addyi(testPaper);
		return testPaper.getId();
	}

}
