package prototype_pattern.demo1;

import java.util.Random;

import org.junit.Test;

public class TestCase {
	private static int maxlength=6;
	@Test
	public void test1() {
		int i=0;
		Mail mail=new Mail(new AdvTemplate());
		mail.setTail("浦发银行版权所有");
		//可以用于多线程并发处理
		while (i<maxlength) {
			Mail cloneMail=mail.clone();
			cloneMail.setAppellation(getRandomString(5)+" 先生（女士）");
			cloneMail.setReceiver(getRandomString(8)+"@"+getRandomString(5)+".com");
			sendMail(cloneMail);
			i++;
		}
	}
	
	public static void sendMail(Mail mail){
		System.out.println("标题："+mail.getSubject()+"     收件人："+mail.getReceiver()+"    ...发送成功！");
	}
	
	public static String getRandomString(int maxLength){
		String source="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sb=new StringBuffer();
		Random rand=new Random();
		for (int i = 0; i <maxLength; i++) {
			sb.append(source.charAt(rand.nextInt(source.length())));
		}
		return sb.toString();
	}
}
