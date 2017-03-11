package basic01.utils;

import org.hibernate.Session;

/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseDao implements IBaseHibernateDAO {
	
	//拿到session可以进行一些的操作
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
	
}