package co.edu.udea.iw.bl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
public class UsuarioBLTest {
	@Autowired
	UsuarioBL usuarioBL;
	
	@Test
	public void testValidateUser() throws ExceptionHandler{
		Boolean userExist = false;
		try {
			userExist = usuarioBL.validateUser("elver", "1g0/KkFdhrmg1DYJWFdd2A==");
			assertTrue(userExist);
		} catch (ExceptionHandler e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
