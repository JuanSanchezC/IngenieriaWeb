package com.udea.edu.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.udea.edu.iw.dao.CiudadDAO;
import com.udea.edu.iw.dao.DataSource;
import com.udea.edu.iw.dto.Ciudad;
import com.udea.edu.iw.exception.ExceptionHandler;

public class CiudadDAOImpl implements CiudadDAO{
	@Override
	public List<Ciudad> getAll() throws ExceptionHandler {
		List<Ciudad> lista = new ArrayList<Ciudad>();
		Session session = null;
		try {
			session = DataSource.getInstance().getSession();
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
			session = DataSource.getInstance().getSession();
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
		Transaction tr = null;
		Session session = null;
		try {
			session = DataSource.getInstance().getSession();
			tr = session.beginTransaction();
			session.save(ciudad);
			tr.commit();
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error insertando ciudad", e);
		}
	}
}
