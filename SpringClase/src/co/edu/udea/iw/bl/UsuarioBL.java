package co.edu.udea.iw.bl;

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
		Boolean userExist = false;
		
		Usuario usuario = usuarioDAO.getByLogin(login);
		if(usuario != null && usuario.getContrasena().equals(pass)){
			userExist = true;
		}
		
		return userExist;
	}
}
