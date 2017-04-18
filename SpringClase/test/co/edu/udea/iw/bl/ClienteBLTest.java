package co.edu.udea.iw.bl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.ExceptionHandler;

/*
 * @author juan.sanchezc@udea.edu.co
 */

/*
 * Anotaciones necesarias para que las pruebas se corran usando Spring.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:co/edu/udea/iw/conf/Spring-Configuration.xml")
public class ClienteBLTest {
	@Autowired
	ClienteBL clienteBL;
	
	@Test
	public void testGetAll() throws ExceptionHandler {
		List<Cliente> result = null;		
		try {
			result = clienteBL.getAll();
			assertTrue(result.size() > 0);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCreateClient() throws ExceptionHandler{
		Boolean goodCreate = false;
		try {
			goodCreate = clienteBL.createClient("123546", "juan", "sanchez", "juan.sanchezc@udea.edu.co", "elver");
			assertTrue(goodCreate);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
