package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.ExceptionHandler;

public class CiudadDAOImpl implements CiudadDAO{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Ciudad> getAll() throws ExceptionHandler {
		List<Ciudad> lista = new ArrayList<Ciudad>();
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Ciudad.class);
			lista = criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error consultando ciudades",e);
		}
		return lista;
	}	

	@Override
	public Ciudad getByCode(Long codigo) throws ExceptionHandler {
		Ciudad ciudad = null;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			ciudad = (Ciudad)session.get(Ciudad.class, codigo);
			//Criteria criteria = session.createCriteria(Ciudad.class);
			//criteria.add(Restrictions.eq("codigo", codigo));
			//ciudad = (Ciudad)criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error consultando ciudad",e);
		}
		return ciudad;
	}

	@Override
	public void insert(Ciudad ciudad) throws ExceptionHandler {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.save(ciudad);
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error insertando ciudad", e);
		}
	}
	
}
