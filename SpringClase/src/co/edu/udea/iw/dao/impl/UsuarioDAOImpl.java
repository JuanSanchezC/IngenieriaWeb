package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionHandler;

/*
 * @author juan.sanchezc@udea.edu.co
 */

/*
 * Implementacion de los metodos definidos por la interfaz UsuarioDAO
 */
public class UsuarioDAOImpl implements UsuarioDAO{
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
	 * Obtiene la lista de todos los Usuarios
	 * @return lista de usuarios
	 * @throws Exception Handler cuando ocurra un excepcion al consultar 
	 * la lista de usuarios en la tabla usuarios
	 */
	@Override
	public List<Usuario> getALL() throws ExceptionHandler{
		List<Usuario> lista = new ArrayList<Usuario>();
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Usuario.class);
			lista = criteria.list();
		} catch (HibernateException e) {
			throw new ExceptionHandler("Error consultando usuarios",e);
		}
		return lista;
	}
}
