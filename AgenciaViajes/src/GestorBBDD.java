import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorBBDD extends Conector{

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
	
	public static ArrayList<Habitacion> getHabitaciones(int IdHotel) {
		conectar();
		ArrayList<Habitacion> habitaciones = new ArrayList<>();
		
		Statement st;
		try {
			st = cn.createStatement();
			String sentenciaSelect = "SELECT * FROM habitaciones WHERE id_hotel="+ IdHotel;
			
			ResultSet resultado = st.executeQuery(sentenciaSelect);
			
			while (resultado.next()) {
				Habitacion h = new Habitacion();
				h.setId(resultado.getInt("id"));
				h.setId_hotel(resultado.getInt("id_hotel"));
				h.setNumero(resultado.getString("numero"));
				h.setDescripcion(resultado.getString("descripcion"));
				h.setPrecio(resultado.getInt("precio"));
				
				habitaciones.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrar();
		
		return habitaciones;
	}
	
	public static ArrayList<Habitacion> getHabitacionesMod() {
		conectar();
		ArrayList<Habitacion> habitaciones = new ArrayList<>();
		
		Statement st;
		try {
			st = cn.createStatement();
			String sentenciaSelect = "SELECT * FROM habitaciones";
			
			ResultSet resultado = st.executeQuery(sentenciaSelect);
			
			while (resultado.next()) {
				Habitacion h = new Habitacion();
				h.setId(resultado.getInt("id"));
				h.setId_hotel(resultado.getInt("id_hotel"));
				h.setNumero(resultado.getString("numero"));
				h.setDescripcion(resultado.getString("descripcion"));
				h.setPrecio(resultado.getInt("precio"));
				
				habitaciones.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrar();
		
		return habitaciones;
	}

	public static ArrayList<Hotel> getHoteles() {
		
		conectar();
		ArrayList<Hotel> hoteles = new ArrayList<>();
		
		Statement st;
		try {
			st = cn.createStatement();
			String sentenciaSelect = "SELECT * FROM hoteles";
			
			ResultSet resultado = st.executeQuery(sentenciaSelect);
			
			while (resultado.next()) {
				Hotel h = new Hotel();
				h.setId(resultado.getInt("id"));
				h.setCif(resultado.getString("cif"));
				h.setNombre(resultado.getString("nombre"));
				h.setGerente(resultado.getString("gerente"));
				h.setEstrellas(resultado.getInt("estrellas"));
				h.setCompania(resultado.getString("compania"));
				
				hoteles.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrar();
		
		return hoteles;
	}

	public static void registrarReserva(Reserva r) {
		
		conectar();
		Statement st;
		
		try {
			st = cn.createStatement();
			
			String sentenciaInsert = "INSERT INTO reservas(id, id_habitacion, dni, desde, hasta) VALUES (?,?,?,?,?)";
			PreparedStatement ps = cn.prepareStatement(sentenciaInsert);
			
			ps.setInt(1, r.getId());
			ps.setInt(2, r.getId_habitacion());
			ps.setString(3, r.getDni());
			ps.setDate(4, (Date) r.getDesde());
			ps.setDate(5, (Date) r.getHasta());
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void modificarHabitacion(Habitacion h, int idHabitacionMod) {
		
		conectar();
		Statement st;
		
		try {
			st = cn.createStatement();
			
			String sentenciaUpdate = "UPDATE habitaciones SET id_hotel=?, numero=?, descripcion=?, precio=? WHERE id ="+idHabitacionMod;
			PreparedStatement ps = cn.prepareStatement(sentenciaUpdate);
			
			ps.setInt(1, h.getId_hotel());
			ps.setString(2, h.getNumero());
			ps.setString(3, h.getDescripcion());
			ps.setDouble(4, h.getPrecio());
			
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getHabitacionesRes(int idHotelRes) {
		
		conectar();
		ArrayList<Reserva> reservas = new ArrayList<>();
		
		Statement st;
		try {
			st = cn.createStatement();
			String sentenciaSelect = "SELECT id, id_habitacion, dni, desde, hasta FROM reservas WHERE id="+idHotelRes;
			
			ResultSet resultado = st.executeQuery(sentenciaSelect);
			
			while (resultado.next()) {
				Reserva r = new Reserva();
				r.setId(resultado.getInt("id"));
				r.setId_habitacion(resultado.getInt("id_habitacion"));
				r.setDni(resultado.getString("dni"));
				r.setDesde(resultado.getDate("desde"));
				r.setHasta(resultado.getDate("hasta"));
				
				reservas.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrar();
		
		return reservas;
	}
}
