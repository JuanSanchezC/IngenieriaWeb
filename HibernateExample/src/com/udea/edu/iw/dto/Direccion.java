package com.udea.edu.iw.dto;

public class Direccion {
	private DireccionId direccionId;
	private String telefono;
	private Ciudad ciudad;
	private Boolean preferida;
	
	public DireccionId getDireccionId() {
		return direccionId;
	}
	public void setDireccionId(DireccionId direccionId) {
		this.direccionId = direccionId;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public Boolean getPreferida() {
		return preferida;
	}
	public void setPreferida(Boolean preferida) {
		this.preferida = preferida;
	}
}
