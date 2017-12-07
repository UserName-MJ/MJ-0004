package cn.test.email.service;

import java.util.List;

import cn.test.email.model.TExamQuestion;
import cn.test.email.model.TestPaper;

public interface AddTiService {

	/*
	 * 添加试题
	 */
	TestPaper addti(String name, String shi);

	List<TestPaper> cha();

	List<TExamQuestion> yl(Integer id);

	List<TExamQuestion> finddan();

	List<TExamQuestion> findduo();

	List<TExamQuestion> findtian();

	List<TExamQuestion> findjian();

	void adddan(int j,int i);

	void addduo(int j,int i1);

	void addtian(int j,int i2);

	void addjian(int j,int i3);

	int addyi(String name, String shi);

	
}
