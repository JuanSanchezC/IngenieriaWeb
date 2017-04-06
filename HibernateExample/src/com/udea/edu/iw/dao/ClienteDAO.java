package com.udea.edu.iw.dao;

import java.util.List;

import com.udea.edu.iw.dto.Cliente;
import com.udea.edu.iw.exception.ExceptionHandler;

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
