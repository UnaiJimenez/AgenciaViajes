import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteModel extends Conector{
	public String dni;
	public String nombre;
	public String apellidos;
	public String direccion;
	public String localidad;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ ", localidad=" + localidad + "]";
	}
	
	public static void registrarCliente(Cliente c) {
		conectar();
		Statement st;
		
		try {
			st = cn.createStatement();
			
			String sentenciaInsert = "INSERT INTO clientes(dni, nombre, apellidos, direccion, localidad) VALUES (?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sentenciaInsert);
			
			ps.setString(1, c.getDni());
			ps.setString(2, c.getNombre());
			ps.setString(3, c.getApellidos());
			ps.setString(4, c.getDireccion());
			ps.setString(5, c.getLocalidad());
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Cliente> getClientes() {
		conectar();
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		Statement st;
		try {
			st = cn.createStatement();
			String sentenciaSelect = "SELECT * FROM clientes";
			
			ResultSet resultado = st.executeQuery(sentenciaSelect);
			
			while (resultado.next()) {
				Cliente c = new Cliente();
				c.setDni(resultado.getString("dni"));
				c.setNombre(resultado.getString("nombre"));
				c.setApellidos(resultado.getString("apellidos"));
				c.setDireccion(resultado.getString("direccion"));
				c.setLocalidad(resultado.getString("localidad"));
				
				clientes.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrar();
		
		return clientes;
	}
}
