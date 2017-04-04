package ejbtest;

import javax.ejb.Remote;

/**
 * EJBTest local interface
 */
@Remote
public interface HelloworldRemote {
	public String sayHello(String word);
}