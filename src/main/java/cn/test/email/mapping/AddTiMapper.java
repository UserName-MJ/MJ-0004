package cn.test.email.mapping;

import java.util.List;

import cn.test.email.model.TExamQuestion;
import cn.test.email.model.TestPaper;
import cn.test.email.model.idvo;
import cn.test.email.model.yivo;

public interface AddTiMapper {

	void addti(TestPaper testPaper);

	List<TestPaper> cha();

	List<Integer> chaid(Integer id);

	List<TExamQuestion> selectti(idvo idvo);

	List<Integer> selectpid(Integer id);

	List<TExamQuestion> finddan();

	List<TExamQuestion> findduo();

	List<TExamQuestion> findtian();

	List<TExamQuestion> findjian();

	void adddan(yivo y);

	void addduo(yivo y);

	void addtian(yivo y);

	void addjian(yivo y);

	void addyi(TestPaper testPaper);

}
