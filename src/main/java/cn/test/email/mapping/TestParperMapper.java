package cn.test.email.mapping;

import java.util.List;

import cn.test.email.model.SeedPaper;
import cn.test.email.model.TestPaper;
import cn.test.email.model.Users;

public interface TestParperMapper {

	void insert(TestPaper testPaper)throws Exception;

	List<TestPaper> selectAll(SeedPaper sp);

	List<SeedPaper> selectSeedPaper(SeedPaper sp);

	void insertSeedPaper(SeedPaper seedPaper);

	List<TestPaper> selectTestPaperById(Integer rank);


	

}
