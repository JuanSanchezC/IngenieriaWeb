package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.ExceptionHandler;
/*
 * author: juan.sanchezc@udea.edu.co
 */

//Clase para establecer retonar una conexión a la base de datos ejemploweb
public class DataSource {
	private static Connection connection;
	
	private static Connection getConnection() throws ExceptionHandler{
		//Variable para obtener una conexión a la base de datos
		Connection con=null;
		//Se carga el driver para manejar MySQL
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//Se obtiene una conexión a la base de datos
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemploweb","root","root");
		} catch (ClassNotFoundException e) {
			throw new ExceptionHandler("Driver Not Found",e);
		} catch (SQLException e) {
			throw new ExceptionHandler("Connection not established",e);
		}
		return con;		
	}
	
	public static Connection getSingletonConnection() throws ExceptionHandler{
		try {
			if(connection == null || connection.isClosed()){
				connection = getConnection();
			}
		} catch (SQLException e) {
			throw new ExceptionHandler("Connection not established", e);
		}
		
		return connection;
	}
}
