import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Formulario {

	public static Cliente pedirDatosCliente(Scanner scan) {
		
		Cliente c = new Cliente();
		
		System.out.println("Introduce el dni del nuevo cliente");
		c.setDni(scan.nextLine());
		System.out.println("Introduce el nombre del nuevo cliente");
		c.setNombre(scan.nextLine());
		System.out.println("Introduce el apellidos del nuevo cliente");
		c.setApellidos(scan.nextLine());
		System.out.println("Introduce el direccion del nuevo cliente");
		c.setDireccion(scan.nextLine());
		System.out.println("Introduce el localidad del nuevo cliente");
		c.setLocalidad(scan.nextLine());
		
		return c;	
	}
	
	public static String pedirDni(Scanner scan) {
		
		System.out.println("Introduce el dni");
		String dni = scan.nextLine();
		
		return dni;
	}

	public static int pedirHotel(Scanner scan) {
	
		System.out.println("Introduce el id del hotel");
		int hotel = Integer.parseInt(scan.nextLine());
		
		return hotel;
	}

	public static int pedirHabitacion(Scanner scan) {
		
		System.out.println("Introduce el id de la habitacion");
		int habitacion = Integer.parseInt(scan.nextLine());
		
		return habitacion;
	}

	public static Reserva pedirFechaReserva(Scanner scan, int idHabitacion, String idDni) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Reserva r = new Reserva();
		
		r.setId_habitacion(idHabitacion);
		r.setDni(idDni);
		System.out.println("Introduce desde cuando quieres reservar la habitacion (dd/MM/yyyy)");
		String inputDate = scan.nextLine();
		Date date = (Date) sdf.parse(inputDate);
		r.setDesde(new java.sql.Date(date.getTime()));
		System.out.println("Introduce hasta cuando quieres reservar la habitacion (dd/MM/yyyy)");
		String inputDate1 = scan.nextLine();
		Date date1 = (Date) sdf.parse(inputDate1);
		r.setHasta(new java.sql.Date(date1.getTime()));
		
		return r;
	}

	public static Habitacion pedirNuevosDatosHabitacion(Scanner scan) {
		
		Habitacion h = new Habitacion();
		
		System.out.println("Introduce el nuevo hotel id de la habitacion");
		h.setId_hotel(Integer.parseInt(scan.nextLine()));
		System.out.println("Introduce el nuevo numero de la habitacion");
		h.setNumero(scan.nextLine());
		System.out.println("Introduce la nueva descripcion de la habitacion");
		h.setDescripcion(scan.nextLine());
		System.out.println("Introduce el nuevo precio de la habitacion");
		h.setPrecio(Double.parseDouble(scan.nextLine()));
		
		return h;
	}
}