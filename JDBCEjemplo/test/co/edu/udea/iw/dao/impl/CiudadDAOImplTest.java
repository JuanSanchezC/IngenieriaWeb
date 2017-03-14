package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.ExceptionHandler;
/*
 * author: juan.sanchezc@udea.edu.co
 */

// Pruebas sobre los métodos de la clase CiudadDAOImpl
public class CiudadDAOImplTest {
	//Se prueba que la lista de ciudades sea mayor que cero
	@Test
	public void testObtener() {
		CiudadDAO ciudadDAO = null;
		List<Ciudad> lista = null;
		try {
			ciudadDAO = new CiudadDAOImpl();
			lista = ciudadDAO.obtener();
			assertTrue(lista.size() > 0);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	//Se que se pueda retornar una ciudad por código
	@Test
	public void testObtenerByCodigo() {
		Long codigo = (long) 1;
		CiudadDAO ciudadDAO = null;
		Ciudad ciudad = null;
		try {
			ciudadDAO = new CiudadDAOImpl();
			ciudad = ciudadDAO.obtener(codigo);
			assertTrue(ciudad != null);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
