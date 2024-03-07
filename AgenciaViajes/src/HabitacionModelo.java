import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HabitacionModelo extends Conector {

	public static int id;
	public int id_hotel;
	public String numero;
	public String descripcion;
	public double precio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", id_hotel=" + id_hotel + ", numero=" + numero + ", descripcion=" + descripcion
				+ ", precio=" + precio + "]";
	}

	public static ArrayList<Habitacion> getHabitaciones(int IdHotel) {
		conectar();
		ArrayList<Habitacion> habitaciones = new ArrayList<>();

		Statement st;
		try {
			st = cn.createStatement();
			String sentenciaSelect = "SELECT * FROM habitaciones WHERE id_hotel=" + IdHotel;

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

	public static ArrayList<Habitacion> getHabitaciones() {
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
	
	public static int getHabitacionesRes(int idHotelRes) throws SQLException {
		conectar();

		Statement st;
		try {
			st = cn.createStatement();
			String sentenciaSelect = "SELECT * FROM habitaciones WHERE id_hotel="+idHotelRes;

			ResultSet resultado = st.executeQuery(sentenciaSelect);

			 if (resultado.next()) {
	                id = resultado.getInt("id");
	            }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrar();
		
		return id;
	}

	public static void modificarHabitacion(Habitacion h, int idHabitacionMod) {

		conectar();
		Statement st;

		try {
			st = cn.createStatement();

			String sentenciaUpdate = "UPDATE habitaciones SET id_hotel=?, numero=?, descripcion=?, precio=? WHERE id ="
					+ idHabitacionMod;
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

}
