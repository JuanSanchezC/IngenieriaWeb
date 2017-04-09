package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.ExceptionHandler;

/*
 * @author juan.sanchezc@udea.edu.co
 */

/*
 * Implementacion de metodos definidos por la interface ClienteDAO
 */
public class ClienteDAOImpl implements ClienteDAO{
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
	 * Retorna la lista de todos Clientes ordenados por feche de creacion
	 * @return lista de Clientes
	 * @throws Exception Handler cuando ocurra una excepcion al consultar la
	 * lista de clientes
	 */
	@Override
	public List<Cliente> getALL() throws ExceptionHandler {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session = null;
		Criteria criteria = null;
		try {
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Cliente.class);
			criteria.addOrder(Order.asc("fechaCreacion"));
			clientes = criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error consultando la lista de clientes", e);
		}		
		return clientes;
	}
	
	/*
	 * Inserta de una nueva entrada en la tabla clientes
	 * @param objeto Cliente a ser insertado
	 * @return variable booleana que indica si la insercion se pudo hacer
	 * @throws Exception Handler cuando ocurra una excepcion al hacer una insercion
	 * en la tabla clientes 
	 */
	@Override
	public boolean createClient(Cliente cliente) throws ExceptionHandler {
		boolean goodInsert = false;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			session.save(cliente);
			goodInsert = true;
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error insertando un cliente", e);
		}
		return goodInsert;
	}

}
