package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.ExceptionHandler;

public class CiudadDAOImplTest {

	@Test
	public void testGetAll() {
		CiudadDAO ciudadDao = null;
		List<Ciudad> ciudades = null;
		try {
			ciudadDao = new CiudadDAOImpl();
			ciudades = ciudadDao.getAll();
			assertTrue(ciudades.size() > 0);
		}
		catch(ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetByCode() {
		CiudadDAO ciudadDAO = null;
		Ciudad ciudad = null;
		long codigo = 1;
		try {
			ciudadDAO = new CiudadDAOImpl();
			ciudad = ciudadDAO.getByCode(codigo);
			assertTrue(ciudad != null);
		}
		catch(ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
