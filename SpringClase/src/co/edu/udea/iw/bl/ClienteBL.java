package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionHandler;

/*
 * @author juan.sanchezc@udea.edu.co
 */

/*
 * Sirve para agregar todos los métodos que va a 
 * utilizar la entidad Cliente
 */
@Transactional
public class ClienteBL {
	private ClienteDAO clienteDAO;
	private UsuarioDAO usuarioDAO;
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	/*
	 * Método que sirve para consultar la lista de clientes
	 * @return lista de cliente
	 * @throw exception cuando ocurra un error al consultar la lista de clientes
	 */
	public List<Cliente> getAll() throws ExceptionHandler{
		return clienteDAO.getALL();
	}
	
	/*
	 * Inserta una nueva entrada en la tabla cliente
	 * @param cedula
	 * @param nombre
	 * @param apellidos
	 * @param email
	 * @param usuarioCrea
	 * @
	 */
	public Boolean createClient(String cedula, String nombres, String apellidos, 
			String email, String usuarioCrea) throws ExceptionHandler{
		Boolean good = false;		
		
		if(cedula == null && "".equals(cedula)){
			throw new ExceptionHandler("La cedula no puede estar vacia");
		}
		if(nombres == null && "".equals(nombres)){
			throw new ExceptionHandler("El nombre no puede estar vacio");
		}
		if(apellidos == null && "".equals(apellidos)){
			throw new ExceptionHandler("Los apellidos no pueden estar vacios");
		}
		if(email == null && "".equals(email)){
			throw new ExceptionHandler("El email no puede estar vacio");
		}
		if(usuarioCrea == null && "".equals(usuarioCrea)){
			throw new ExceptionHandler("El usuario que crea no puede estar vacio");
		}
		
		//validar email
		
		//validar que usuarioCrea si existe
		Usuario usuario = usuarioDAO.getByLogin(usuarioCrea);
		if(usuario == null){
			throw new ExceptionHandler("El usuario que crea no existe");
		}
		
		//validar que no haya un usuario con la misma cedula
		
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(Boolean.FALSE);
		
		clienteDAO.createClient(cliente);
		good = true;
		
		// Clase logica del negocio de usuario con un metodo que permita validar el usuario dados sus login y pws
		
		return good;
	}
}
