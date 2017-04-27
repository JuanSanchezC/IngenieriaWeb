package co.edu.udea.iw.bl;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionHandler;

/*
 * @author juan.sanchezc@udea.edu.co
 */

/*
 * Sirve para agregar todos los métodos que va a 
 * utilizar la entidad usuario
 */
@Transactional
public class UsuarioBL {
	private UsuarioDAO usuarioDAO;
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	/*
	 * Válida un usuario dado su login y password
	 * @param login: login del usuario
	 * @paran pass: contraseña del usuario
	 * @return userExist: bandera indica la validación del usuario
	 */
	public Boolean validateUser(String login, String pass) throws ExceptionHandler{	
		
		if(login == null || login.isEmpty()){
			throw new ExceptionHandler("campo no puede estar vacio");
		}
		
		if(pass == null || pass.isEmpty()){
			throw new ExceptionHandler("campo no puede estar vacio");
		}
		
		Usuario usuario = usuarioDAO.getByLogin(login);
		
		if(usuario == null){
			throw new ExceptionHandler("usuario no existe");
		}
		
		if(!usuario.getContrasena().equals(pass)){
			throw new ExceptionHandler("usuario o contraseña invalido");
		}
		
		return true;
	}
}
