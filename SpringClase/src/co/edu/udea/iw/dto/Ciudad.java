/*
* @author juan.sanchezc@udea.edu.co
*/

package co.edu.udea.iw.dto;

/*
 * POJO que representa una entidad Ciudad de la tabla ciudades
 */
public class Ciudad {
	private	long	codigo;
	private	String nombre;
	private	String codigoArea;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	
}
