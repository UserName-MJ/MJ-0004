package com.log.logtest;

import org.apache.log4j.Logger;

public class Test {
	private  Logger log =Logger.getLogger("test123");
	public  void recordLog(){
		log.info("single log test .......");
	} 
}
