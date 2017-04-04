package ejbtest;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * @author 陈明让
 * @data 2017年4月3日
 */
public class TestCase {
	public static void main(String[] args) throws Exception{
		Properties prop = new Properties();
		//JBoss实现配置 
		//Context.INITIAL_CONTEXT_FACTORY ===>  org.jnp.interfaces.NamingContextFactory
		//Context.PROVIDER_URL  ===> localhost:port
		//java.naming.factory.url.pkgs  ===> org.jboss.naming:org.jnp.interfaces可选
		prop.setProperty(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
		prop.setProperty(Context.PROVIDER_URL, "t3://localhost:7070");
		InitialContext ctx = new InitialContext(prop);
		//#后面的包路径必须和ejb中一致
		//如果是JBoss部署写成HelloWord/remote即可
		//接口可以打成jar包
		HelloworldRemote test = (HelloworldRemote) ctx.lookup("HelloWord#ejbtest.HelloworldRemote");
		System.out.println(test.sayHello(" chen!"));
	}
}
