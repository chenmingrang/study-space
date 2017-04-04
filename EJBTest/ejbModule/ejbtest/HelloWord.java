package ejbtest;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class EJBTest
 */
//Jboss可以不写mappedName
@Stateless(mappedName="HelloWord")
public class HelloWord implements HelloworldRemote {

	/**
     * Default constructor. 
     */
    public HelloWord() {
        
    }

	@Override
	public String sayHello(String word) {
		return "Hello "+word +" !";
	}
}