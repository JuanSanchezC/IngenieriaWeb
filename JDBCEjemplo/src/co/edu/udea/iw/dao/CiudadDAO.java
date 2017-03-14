package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.ExceptionHandler;
/*
 * @author: juan.sanchezc@udea.edu.co
 */

//Interfaz que define los métodos que se pueden hacer sobre la base de datos de ciudades
public interface CiudadDAO {
	//Obtiene las ciudades ordenadas por nombre
	public List<Ciudad> obtener() throws ExceptionHandler;
	
	//Obtener ciudad por su codigo
	public Ciudad obtener(Long codigo) throws ExceptionHandler;
}
