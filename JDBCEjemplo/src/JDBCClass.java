import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * @autor: juan.sanchezc@udea.edu.co
 */

/*
 * Clase para realizar una consulta a una base de datos en MySQL
 */
public class JDBCClass {
	
	public static void main(String[] args) {
		//Se llama al método que muestra en consola la consulta de las ciudades 
		consultarCiudades();
	}
	
	public static void consultarCiudades(){
		//Variable para obtener una conexión a la base de datos
		Connection con=null;
		//Variable para preparar la consulta que se desea hacer
		PreparedStatement ps=null;
		//Variable para guardar el resultado de la consulta a la base de datos
		ResultSet rs=null;
		
		try {
			//Se carga el driver para manejar MySQL
			Class.forName("com.mysql.jdbc.Driver");
			//Se obtiene una conexión a la base de datos
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemploweb","root","root");
			//Se prepara la consulta a la base de datos
			ps = con.prepareStatement("SELECT * FROM ciudades");
			//Se obtiene el resultado de la consulta
			rs = ps.executeQuery();
			
			//Se itera el resultado de la consulta realizada y se muestra en consola
			while(rs.next()){
				System.out.println(rs.getString("codigo")+":  "+rs.getString("Nombre"));				
			}
		//Se maneja las excepciones que pueda ocurrir
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Se cierra la conexión
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
