package co.edu.udea.iw.ws;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/*
 * @author juan.sanchezc@udea.edu.co
 */

@Path("saludo") // se define la URL con la que responderá el servicio
public class PrimerEjemplo {
	
	@GET //se define que es un meto get
	@Produces(MediaType.TEXT_HTML) //se define el tipo de dato que se retorna	
	public String saludar(){
		return "Buenas las tengan";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("2")
	public String saludar2(){
		return "<h1>Nuevo puto saludo</h1>";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("3")
	public String saludar3(@QueryParam("a")String nombre){
		return "Hola puto "+nombre;
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Path("4")
	public String saludar4(@QueryParam("a") String nombre){
		return "Hola puto "+nombre;
	}
}
