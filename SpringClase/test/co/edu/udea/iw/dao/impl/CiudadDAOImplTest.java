package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.ExceptionHandler;

/*
 * @author: juan.sanchezc@udea.edu.co
 */

/*
 * Implementacion de pruebas sobre los metodos de CiudadDAOImpl
 */

/*
 * Anotaciones necesarias para que las pruebas se corran usando Spring
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:co/edu/udea/iw/conf/Spring-Configuration.xml")
public class CiudadDAOImplTest {
	@Autowired
	CiudadDAO ciudadDAO = null;
	
	/*
	 * Prueba para el metodo getALL()
	 */
	@Test
	public void testGetAll() {		
		List<Ciudad> ciudades = null;
		try {
			ciudades = ciudadDAO.getAll();
			assertTrue(ciudades.size() > 0);
		}
		catch(ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	/*
	 * Prueba para el metodo getByCode()
	 */
	@Test
	public void testGetByCode() {
		Ciudad ciudad = null;
		long codigo = 1;
		try {
			ciudad = ciudadDAO.getByCode(codigo);
			assertTrue(ciudad != null);
		}
		catch(ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
