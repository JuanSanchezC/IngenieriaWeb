package com.udea.edu.iw.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udea.edu.iw.exception.ExceptionHandler;

/*
 * author: juan.sanchezc@udea.edu.co
 */
public class DataSource {
	private static DataSource dsInstance;
	private SessionFactory factory = null;
	private Configuration conf = new Configuration();
	
	
	private DataSource() {}
	
	public static DataSource getInstance() {
		if(dsInstance == null)
			dsInstance = new DataSource();
		return dsInstance;
	}
	public Session getSession() throws ExceptionHandler {
		try {
			if(factory == null) {
				conf.configure("com/udea/edu/iw/conf/hibernate.cfg.xml");
				factory = conf.buildSessionFactory();
			}
			return factory.openSession();
		}
		catch(HibernateException e) {
			throw new	ExceptionHandler("Error configurando la session", e);
		}
	}
}
