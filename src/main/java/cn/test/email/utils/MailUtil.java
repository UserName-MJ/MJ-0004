package cn.test.email.utils;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

/**
 * 
 * @ClassName: MailUtil  
 * @Description: 这是一个邮件发送的工具类 ,此工具类依赖于 commons-mail 这个jar包
 * @author Administrator  
 * @date 2017年11月17日 下午7:26:05  
 */
public class MailUtil {
	//这个是邮件smtp的服务器
	private final static String HOSTNAME="smtp.163.com";
	//发件人的邮箱地址
	private final static String USEREMAIL="q1162280694@163.com";
	//发件人的密码，或者授权码！！！
	private final static String PASSWORD= "asd123asd";
		
    public static String randomUUID(){
    	//创建对象
    	//产生每次不重复的字符串
    	UUID r = UUID.randomUUID();//UUID无构造函数，不可改
    	return r.toString();
    }
    public static String rand(){
    	String str = "";
		str += (int) (Math.random() * 9 + 1);//产生一位（1-10）
		for (int i = 0; i < 5; i++) {
			str += (int) (Math.random() * 10);//
		}
		String num = str;
		return num;
    }
    
    /**
     *  邮件网络附件的获取工具
     * @Title: getAttachmentByUrl  
     *   @param Url (这个填写网络资源的url路径)
     *   @param fileName  (这个是发送到目标邮件的文件名)
     *   @return EmailAttachment 
     * @throws
     */
    public static EmailAttachment getAttachmentByUrl(String Url,String fileName){
    	EmailAttachment attachment = new EmailAttachment();
		try {
			attachment.setURL(new URL(Url));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		attachment.setDisposition(EmailAttachment.ATTACHMENT); 
		attachment.setName(fileName);
		return attachment;
    }         
    
    /**
     *  邮件本地附件的获取工具
     * @Title: getAttachmentByPath  
     *   @param path (这个填写本地资源的url路径)
     *   @param fileName  (这个是发送到目标邮件的文件名)
     *   @return EmailAttachment
     * @throws
     */
    public static EmailAttachment getAttachmentByPath(String path,String fileName){
    	EmailAttachment attachment = new EmailAttachment();
    	try {
    		attachment.setPath(path);
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	attachment.setDisposition(EmailAttachment.ATTACHMENT); 
    	attachment.setName(fileName);
    	return attachment;
    }
    /**
     * 发送带附件的邮件,单人发送
     * @Title: sendEmail  
     *   @param toEmail (收信人邮件地址)
     *   @param subject (邮件主题)
     *   @param content (邮件内容)
     *   @param attachment (附件)
     *   @throws Exception void
     * @throws
     */
    public static void sendEmail(String toEmail,String subject,String content,
    		EmailAttachment attachment,boolean isHtmlText) throws Exception{ 
    	
    	//（3）添加附件到我们的邮件中 
    	MultiPartEmail email = new MultiPartEmail(); 
    	email.setHostName(HOSTNAME);
    	email.setAuthentication(USEREMAIL,PASSWORD); 
    	email.setFrom(USEREMAIL);
    	email.addTo(toEmail);
    	email.setSubject(subject);
    	if(isHtmlText){
    		//设置发送内容
    		email.setContent(content,"text/html;charset=UTF-8");
    	}else{
    		email.setMsg(content);
    	}
    	
    	if(attachment!=null){
    		//添加附件 
    		email.attach(attachment);
    	}
    	email.setCharset("UTF-8");
       	//发送邮件 email.send();
		email.send();
    	
    }

    /**
     * 发送带附件的邮件,多人发送
     * @Title: sendEmails  
     *   @param toEmails (收信人邮件地址)
     *   @param subject (邮件主题)
     *   @param content (邮件内容)
     *   @param attachment (附件)
     *   @throws Exception void
     * @throws
     */
    public static void sendEmails(String[] toEmails,String subject,String content,
    		EmailAttachment attachment,boolean isHtmlText) throws Exception{ 
    	 for (int i = 0; i < toEmails.length; i++) {
	    	//（3）添加附件到我们的邮件中 
	    	MultiPartEmail email = new MultiPartEmail(); 
	    	email.setHostName(HOSTNAME);
	    	email.setAuthentication(USEREMAIL,PASSWORD); 
	    	email.setFrom(USEREMAIL);
	    	email.setSubject(subject);
	    	if(isHtmlText){
	    		//设置发送内容
	    		email.setContent(content,"text/html;charset=UTF-8");
	    	}else{
	    		email.setMsg(content);
	    	}
	    	
	    	if(attachment!=null){
	    		//添加附件 
	    		email.attach(attachment);
	    	}
	    	email.setCharset("UTF-8");
    		//设置收信人地址
        	email.addTo(toEmails[i]);
        	email.send();
		}
 
    }
}
