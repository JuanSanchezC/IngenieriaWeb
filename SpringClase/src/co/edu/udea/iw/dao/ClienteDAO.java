package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.ExceptionHandler;

public interface ClienteDAO {
	/*
	 * Entrega la lista de clientes ordenados por su fecha de creacion
	 * @return lista de clientes
	 * @throws ExceptionHandler cuando ocurra una excepcion
	 */
	public List<Cliente> getALL() throws ExceptionHandler;
	
	/*
	 * Crea una nueva entrada en la tabla cliente
	 */
	public boolean createClient(Cliente cliente) throws ExceptionHandler;
}
