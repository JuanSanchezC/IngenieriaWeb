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

/*
 * @author: juan.sanchezc@udea.edu.co
 */

/*
 * Implementacion de metodos definidos por la Interface CiudadDAO
 */
public class CiudadDAOImpl implements CiudadDAO{
	//Objeto para manejar conexiones a la base de datos
	private SessionFactory sessionFactory;
	
	// Metodos setters y getters para el objeto sessionFactory
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/*
	 * Obtiene la lista de todas las Ciudades
	 * @return lista de Ciudades
	 * @throws ExceptionHandler cuando ocurra una excepcion al consultar
	 * la lista de ciudades
	 */
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
	
	/*
	 * Obtiene una Ciudad de acuerdo al codigo pasado como parametro
	 * @param codigo de ciudad a consultar
	 * @return ciudad de acuerdo al codigo pasado como parametro
	 * @throws ExceptionHandler cuando ocurra un error consultado una 
	 * ciudad por codigo
	 */
	@Override
	public Ciudad getByCode(Long codigo) throws ExceptionHandler {
		Ciudad ciudad = null;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			ciudad = (Ciudad)session.get(Ciudad.class, codigo);
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error consultando ciudad",e);
		}
		return ciudad;
	}

	/*
	 * Inserta a una Ciudad en la tabla ciudades
	 * @param objeto Ciudad
	 * @throws ExceptionHandler cuando ocurra una excepcion al insertar una
	 * entrada en la tabla ciudades
	 */
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
