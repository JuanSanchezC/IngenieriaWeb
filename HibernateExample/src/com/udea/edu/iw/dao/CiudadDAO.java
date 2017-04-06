package com.udea.edu.iw.dao;

import java.util.List;

import com.udea.edu.iw.dto.Ciudad;
import com.udea.edu.iw.exception.ExceptionHandler;

public interface CiudadDAO {
	//*	Get all cities ordered by name
		public  List<Ciudad> getAll() throws ExceptionHandler;
		
		//* Get a ciudad object by its PK
		public Ciudad getByCode(Long codigo) throws ExceptionHandler;
		
		//* Insert a ciudad object
		public void insert(Ciudad ciudad) throws ExceptionHandler;
}
