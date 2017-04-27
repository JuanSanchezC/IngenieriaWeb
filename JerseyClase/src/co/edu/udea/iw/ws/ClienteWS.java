package co.edu.udea.iw.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.ClienteBL;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.ClienteJersey;
import co.edu.udea.iw.exception.ExceptionHandler;

/*
 * @author juan.sanchezc@udea.edu.co
 */

@Path("cliente")
@Component
public class ClienteWS {
	@Autowired
	ClienteBL clienteBL;
	
	@POST	
	@Produces(MediaType.TEXT_HTML)
	public void createCliente(@QueryParam("cedula")String cedula, @QueryParam("nombres")String nombres, 
			@QueryParam("apellidos")String apellidos, @QueryParam("email")String email, 
			@QueryParam("usuarioCrea")String usuarioCrea)throws RemoteException{
		try {
			clienteBL.createClient(cedula, nombres, apellidos, email, usuarioCrea);
		} catch (ExceptionHandler e) {
			throw new RemoteException("Error creando cliente", e);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteJersey> getAll() throws RemoteException{
		List<ClienteJersey> respuesta = new ArrayList<ClienteJersey>();
		try {
			for(Cliente cliente: clienteBL.getAll()){
				ClienteJersey clienteJersey = new ClienteJersey(
						cliente.getCedula(), cliente.getNombres(), 
						cliente.getApellidos(), cliente.getEmail());
				respuesta.add(clienteJersey);
			}
		} catch (ExceptionHandler e) {
			throw new RemoteException("Problema consultando clientes");
		}
		return respuesta;
	}
}
