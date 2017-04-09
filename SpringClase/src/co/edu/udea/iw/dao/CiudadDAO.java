package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.ExceptionHandler;

/*
 * @author: juan.sanchezc@udea.edu.co
 */

/*
 * Interface que implementa del patron Facade para el manejo de
 * objetos Ciudad 
 */
public interface CiudadDAO {
	
	/*
	 * Definicion de metodo para la entrega de toda la lista de
	 * Ciudades.
	 * @return Lista de Ciudades 
	 * @throws ExceptionHandler cuando ocurra una excepcion al
	 * consultar la lista de ciudades.
	 */
	public  List<Ciudad> getAll() throws ExceptionHandler;
	
	/*
	 * Definicion de metodo para obtener una ciudad de acuerdo a 
	 * su codigo
	 * @param Codigo de ciudad
	 * @return Ciudad
	 * @throws ExceptionHandler cuando ocurra una excepcion al
	 * realizar la consulta de ciudad
	 */
	public Ciudad getByCode(Long codigo) throws ExceptionHandler;
	
	/*
	 * Definicion de metodo para insertar una entrada en la tabla
	 * Ciudad
	 * @param objeto Ciudad
	 * @@throws ExceptionHandler cuando ocurra una excepcion al
	 * realizar una insercion en la tabla Ciudad
	 */
	public void insert(Ciudad ciudad) throws ExceptionHandler;
	
}