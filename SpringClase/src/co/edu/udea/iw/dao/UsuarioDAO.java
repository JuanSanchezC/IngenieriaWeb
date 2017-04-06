package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionHandler;

public interface UsuarioDAO {
	public List<Usuario> getALL() throws ExceptionHandler;
}
