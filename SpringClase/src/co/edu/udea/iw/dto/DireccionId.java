package co.edu.udea.iw.dto;

import java.io.Serializable;

/*
 * @author juan.sanchezc@udea.edu.co
 */

/*
 * Clase que define objeto que representa la clave primaria de la
 * tabla direcciones
 */
public class DireccionId implements Serializable{
	private Long codigo;
	private Cliente cliente;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
