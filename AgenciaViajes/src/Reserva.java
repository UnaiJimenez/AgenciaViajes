import java.util.Date;

public class Reserva {

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
		
}
