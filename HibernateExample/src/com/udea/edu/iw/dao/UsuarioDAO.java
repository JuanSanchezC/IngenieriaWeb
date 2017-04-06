package com.udea.edu.iw.dao;

import java.util.List;

import com.udea.edu.iw.dto.Usuario;
import com.udea.edu.iw.exception.ExceptionHandler;

public interface UsuarioDAO {
	public List<Usuario> getALL() throws ExceptionHandler;
}
