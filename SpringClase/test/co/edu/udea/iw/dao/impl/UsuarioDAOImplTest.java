package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionHandler;

/*
 * @author juan.sanchezc@udea.edu.co
 */

/*
 * Implementacion de prueba sobre los metodos de UsuarioDAOImpl
 */

/*
 * Anotaciones necesarias para que las pruebas se corran usando Spring.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:co/edu/udea/iw/conf/Spring-Configuration.xml")
public class UsuarioDAOImplTest {
	@Autowired
	UsuarioDAO usuarioDAO;
	
	/*
	 * Prueba para el metodo getALL()
	 */
	@Test
	public void getAll() {
		List<Usuario> usuarios = null;
		try {
			usuarios = usuarioDAO.getALL();
			assertTrue(usuarios.size()>0);
			System.out.println("Rol del usuario 0: "+usuarios.get(0).getRol().getNombre());
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
