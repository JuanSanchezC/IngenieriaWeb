package co.edu.udea.iw.dao;

import java.util.List;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.ExceptionHandler;

// * Interface for facade pattern implementation by DAO 
public interface CiudadDAO {
	
	//*	Get all cities ordered by name
	public  List<Ciudad> getAll() throws ExceptionHandler;
	
	//* Get a ciudad object by its PK
	public Ciudad getByCode(Long codigo) throws ExceptionHandler;
	
	//* Insert a ciudad object
	public void insert(Ciudad ciudad) throws ExceptionHandler;
	
	//* Update a ciudad object
	//public void update(Ciudad ciudad) throws ExceptionHandler;
	
	//* Delete a ciudad object
	//public void delete(Ciudad ciudad) throws ExceptionHandler;
	
}