package com.log.logtest;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Logger log =Logger.getLogger(App.class);
    public static void main( String[] args ) throws Exception
    {
    	log.info("开始执行任务");
    	//链接
    	connectDb();
    	try {
    	log.info("链接成功");
    	//开启事务
    	openTran();
    	log.info("已开启事务");
    	//持久化数据
    	persistData();
    	log.info("数据操作：持久化数据");
    	//提交事务
    	commitTran();
    	log.info("事务已提交");
    	//关闭连接
    	Test t=new Test();
    	t.recordLog();
    	throw new Exception("操作异常");
    	} catch (Exception e) {
			log.error("任务执行失败",e);
			callback();
			throw e;
		}finally {
			try {
				log.info("关闭链接");
				closeConnet();
			} catch (Exception e2) {
				log.error("关闭连接失败", e2);
			}
		}
    }
	private static void callback() throws Exception {
		 try {
			
		} catch (Exception e) {
			throw new CallbackException("失败回滚异常",e);
		}
	}
	private static void closeConnet() {
		// TODO Auto-generated method stub
		
	}
	private static void commitTran() {
		// TODO Auto-generated method stub
		
	}
	private static void persistData() {
		// TODO Auto-generated method stub
		
	}
	private static void openTran() {
		// TODO Auto-generated method stub
		
	}
	private static void connectDb() {
		// TODO Auto-generated method stub
		
	}
}
