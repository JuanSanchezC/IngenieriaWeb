package co.edu.udea.iw.dto;

/*
 * @author juan.sanchezc@udea.edu.co
 */

/*
 * POJO que representa una entidad Direccion de la tabla direcciones
 */
public class Direccion {
	// clave compuesta reprentada por un objeto DireccionID
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
