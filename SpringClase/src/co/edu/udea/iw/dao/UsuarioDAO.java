package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionHandler;

/*
 * @author: juan.sanchezc@udea.edu.co
 */

/*
 * Interface que implementa el patron Facade para el manejo de
 * objetos Usuario
 */
public interface UsuarioDAO {
	/*
	 * Definicion de metodo para acceder a la lista de todos los
	 * Usuarios
	 * @return lista de Usuarios
	 * @throws ExceptionHandler cuando ocurra una excepcion al consultar
	 * la lista de Usuarios
	 */
	public List<Usuario> getALL() throws ExceptionHandler;
}
