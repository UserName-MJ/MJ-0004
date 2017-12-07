package cn.test.email.service;

import java.io.IOException;

import jxl.read.biff.BiffException;

public interface SaveQuestionService {

	void jxExcle(String string)throws BiffException, IOException;

}
