package basic01.utils;

import org.hibernate.Session;

/**
 * Data access interface for domain model
 * @author MyEclipse Persistence Tools
 */
public interface IBaseHibernateDAO {
	public Session getSession();
}