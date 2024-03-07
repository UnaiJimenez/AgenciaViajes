import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ReservaModelo extends Conector{
	public int id;
	public int id_habitacion;
	public String dni;
	public Date desde;
	public Date hasta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(int id_habitacion) {
		this.id_habitacion = id_habitacion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", id_habitacion=" + id_habitacion + ", dni=" + dni + ", desde=" + desde
				+ ", hasta=" + hasta + "]";
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
			ps.setDate(4, (java.sql.Date) r.getDesde());
			ps.setDate(5, (java.sql.Date) r.getHasta());

			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Reserva> getReservas(int idHabitacionRes) {
		
		conectar();
		ArrayList<Reserva> reservas = new ArrayList<>();

		Statement st;
		try {
			st = cn.createStatement();
			String sentenciaSelect = "SELECT * FROM reservas";

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
