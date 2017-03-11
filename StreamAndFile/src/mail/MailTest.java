/**
 * 
 */
package mail;

import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author 陈明让
 * @data 2017年3月7日
 */
public class MailTest {
	public static void main(String[] args) throws Exception, MessagingException {
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.126.com");
		props.setProperty("mail.smtp.auth", "true");
		//初始化Session,注意用户和密码的指定试,其实此过程是进行base64编码
		Session mailSession = Session.getDefaultInstance(props);
		//显示与服务器交互过程
		mailSession.setDebug(true);
		//第二步：
		//声明一个邮件类型
		MimeMessage msg = new MimeMessage(mailSession);
		//设置发件人
		msg.setFrom(new InternetAddress("chenmingrang@126.com"));
		//设置收件人
		msg.setRecipient(RecipientType.TO,new InternetAddress("15039043881@163.com"));
		//设置主题
		msg.setSubject("测试");
		//设置内容
		msg.setContent("这是测试内容","text/plain;charset=UTF-8");
		//第三步：发邮件
		Transport ts = mailSession.getTransport();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入密码：");
		String password = scanner.nextLine().trim();
		scanner.close();
		ts.connect("chenmingrang", password);
		ts.sendMessage(msg, msg.getAllRecipients());

	}
}
