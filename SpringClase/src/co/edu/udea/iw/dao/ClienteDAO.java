package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.ExceptionHandler;

/*
 * @author: juan.sanchezc@udea.edu.co
 */

/*
 * Interface que implementa el patron Facade para el manejo de objetos
 * Cliente
 */
public interface ClienteDAO {
	/*
	 * Definición de metorodo para la entrega la lista de clientes ordenados
	 * por su fecha de creacion
	 * @return lista de clientes
	 * @throws ExceptionHandler cuando ocurra una excepcion al consultar la 
	 * lista de Clientes
	 */
	public List<Cliente> getALL() throws ExceptionHandler;
	
	/*
	 * Definicion de metodo para crear una nueva entrada en la tabla Cliente
	 * @param objeto Cliente
	 * @throws ExceptionHandler cuando ocurra una excepcion al insertar una
	 * entrada en la tabla Cliente
	 */
	public boolean createClient(Cliente cliente) throws ExceptionHandler;
}
