import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HotelModelo extends Conector{
	public int id;
	public String cif;
	public String nombre;
	public String gerente;
	public int estrellas;
	public String compania;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", cif=" + cif + ", nombre=" + nombre + ", gerente=" + gerente + ", estrellas="
				+ estrellas + ", compania=" + compania + "]";
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
	
	public static ArrayList<Hotel> getHotel(int idHotel) {

		conectar();
		ArrayList<Hotel> hotel = new ArrayList<>();

		Statement st;
		try {
			st = cn.createStatement();
			String sentenciaSelect = "SELECT * FROM hoteles WHERE id="+idHotel;

			ResultSet resultado = st.executeQuery(sentenciaSelect);

			while (resultado.next()) {
				Hotel h = new Hotel();
				h.setId(resultado.getInt("id"));
				h.setCif(resultado.getString("cif"));
				h.setNombre(resultado.getString("nombre"));
				h.setGerente(resultado.getString("gerente"));
				h.setEstrellas(resultado.getInt("estrellas"));
				h.setCompania(resultado.getString("compania"));

				hotel.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrar();

		return hotel;
	}
	
	/*
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
		
		
		return;
	}
}
*/
}
