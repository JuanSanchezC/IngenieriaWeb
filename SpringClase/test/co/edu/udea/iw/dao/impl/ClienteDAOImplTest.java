package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionHandler;

/*
 * @author juan.sanchezc@udea.edu.co
 */

/*
 * Implementacion de prueba sobre los metodos de ClienteDAOImpl
 */

/*
 * Anotaciones necesarias para que las pruebas se corran usando Spring.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:co/edu/udea/iw/conf/Spring-Configuration.xml")
public class ClienteDAOImplTest {
	@Autowired
	ClienteDAO clienteDAO;

	/*
	 * Prueba para el metodo getALL()
	 */
	@Test
	public void testGetALL() {
		List<Cliente> resultado = null;
		try {
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
	
	/*
	 * Prueba para el metodo createClient()
	 */
	@Test
	public void testCreateClient(){
		Cliente cliente = null;
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
			
			boolean variable = clienteDAO.createClient(cliente);
			assertTrue(variable);			
			
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
