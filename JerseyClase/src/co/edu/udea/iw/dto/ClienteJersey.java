package co.edu.udea.iw.dto;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * @author juan.sanchezc@udea.edu.co
 */

@XmlRootElement
public class ClienteJersey {
	private String cedula;
	private String nombres;
	private String apellidos;
	private String correo;	
	
	public ClienteJersey() {
		
	}
	
	public ClienteJersey(String cedula, String nombres, String apellidos, String correo) {
		super();
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
