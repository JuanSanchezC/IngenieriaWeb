package co.edu.udea.iw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.ExceptionHandler;
/*
 * author:juan.sanchezc@udea.edu.co
 */

public class CiudadDAOImpl implements CiudadDAO{
	
	@Override
	public List<Ciudad> obtener() throws ExceptionHandler {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		List<Ciudad> lista = new ArrayList<Ciudad>();
		try {
			con = DataSource.getSingletonConnection();
			ps = con.prepareStatement("SELECT * FROM ciudades");
			rs = ps.executeQuery();
			//Se itera el resultado de la consulta realizada y se muestra en consola
			while(rs.next()){
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				lista.add(ciudad);
			}
		} catch (SQLException e) {
			throw new ExceptionHandler("Error al ejecutar la consulta", e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				throw new ExceptionHandler("Error cerrando conexcion", e2);
			}
		}
		return lista;
	}

	@Override
	public Ciudad obtener(Long codigo) throws ExceptionHandler {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		Ciudad ciudad = new Ciudad();
		try {
			con = DataSource.getSingletonConnection();
			ps = con.prepareStatement("SELECT * FROM ciudades WHERE codigo=?");
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			if(rs.next()){
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
			}
		} catch (Exception e) {
			throw new ExceptionHandler("Error al ejecutar la consulta", e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				throw new ExceptionHandler("Error cerrando conexcion", e2);
			}
		}
		return ciudad;
	}

}
