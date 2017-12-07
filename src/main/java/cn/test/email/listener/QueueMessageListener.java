package cn.test.email.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import cn.test.email.utils.MailUtil;



/**
 * Created by Administrator on 2017/1/5.
 */
public class QueueMessageListener implements MessageListener {

	public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        String[] srr=null;
        try {
			srr=tm.getText().split(":");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
         try {
			MailUtil.sendEmail(srr[0], "王者注册验证码", "验证码:"+srr[1], null, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }
}