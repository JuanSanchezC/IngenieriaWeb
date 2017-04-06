package com.udea.edu.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.udea.edu.iw.dao.UsuarioDAO;
import com.udea.edu.iw.dto.Usuario;
import com.udea.edu.iw.exception.ExceptionHandler;

public class UsuarioDAOImplTest {

	@Test
	public void testGetALL() {
		UsuarioDAO usuarioDao = null;
		List<Usuario> usuarios = null;
		try {
			usuarioDao = new UsuarioDAOImpl();
			usuarios = usuarioDao.getALL();
			assertTrue(usuarios.size()>0);
			System.out.println("Rol del usuario 0: "+usuarios.get(0).getRol().getNombre());
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
