package com.udea.edu.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.udea.edu.iw.dao.DataSource;
import com.udea.edu.iw.dao.UsuarioDAO;
import com.udea.edu.iw.dto.Usuario;
import com.udea.edu.iw.exception.ExceptionHandler;

public class UsuarioDAOImpl implements UsuarioDAO{
	@Override
	public List<Usuario> getALL() throws ExceptionHandler{
		List<Usuario> lista = new ArrayList<Usuario>();
		Session session = null;
		try {
			session = DataSource.getInstance().getSession();
			Criteria criteria = session.createCriteria(Usuario.class);
			lista = criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error consultando usuarios",e);
		}finally {
			if(session != null){
				session.close();
			}
		}
		return lista;
	}
}
