package com.udea.edu.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.udea.edu.iw.dao.ClienteDAO;
import com.udea.edu.iw.dto.Cliente;
import com.udea.edu.iw.dto.Usuario;
import com.udea.edu.iw.exception.ExceptionHandler;

public class ClienteDAOImplTest {

	@Test
	public void testGetALL() {
		ClienteDAO clienteDAO = null;
		List<Cliente> resultado = null;
		try {
			clienteDAO = new ClienteDAOImpl();
			resultado = clienteDAO.getALL();
			
			for(Cliente cliente:resultado){
				System.out.println(cliente.getNombres()+" "+cliente.getApellidos());
			}
			
			assertTrue(resultado.size()>0);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testCreateClient() {
		Cliente cliente = null;
		ClienteDAO clienteDAO = null;
		Usuario usuario = null;
		try {
			usuario = new Usuario();
			usuario.setLogin("elver");
			
			cliente = new Cliente();
			cliente.setCedula("1031649876");
			cliente.setNombres("Juan Pedro");
			cliente.setApellidos("Soto Giraldo");
			cliente.setEmail("juansoto@cualquiecosa.com");
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date());
			
			clienteDAO = new ClienteDAOImpl();
			
			boolean variable = clienteDAO.createClient(cliente);
			assertTrue(variable);			
			
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
