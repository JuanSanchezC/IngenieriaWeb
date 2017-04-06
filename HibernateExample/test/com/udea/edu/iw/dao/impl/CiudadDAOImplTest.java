package com.udea.edu.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.udea.edu.iw.dao.CiudadDAO;
import com.udea.edu.iw.dto.Ciudad;
import com.udea.edu.iw.exception.ExceptionHandler;

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
