import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	
	public static final int SALIR = 0;
	public static final int REGISTRAR_CLIENTE = 1;
	public static final int VER_CLIENTES = 2;
	public static final int VER_HOTELES_CON_SUS_HABITACIONES = 3;
	public static final int REALIZAR_RESERVA = 4;
	public static final int MODIFICAR_HABITACION = 5;
	public static final int VER_RESERVAS = 6;

	public static void run() throws ParseException, SQLException {
		
		Scanner scan = new Scanner(System.in);
		int opcion;
		
		do {
			Visor.menu();
			opcion = Integer.parseInt(scan.nextLine());
			
			switch (opcion) {
			case SALIR:
				System.out.println("Finalizar programa...");
				break;
				
			case REGISTRAR_CLIENTE:
				Cliente cliente = Formulario.pedirDatosCliente(scan);
				ClienteModel.registrarCliente(cliente);
				break;
				
			case VER_CLIENTES:
				ArrayList<Cliente> clientes = ClienteModel.getClientes();
				Visor.mostrarClientes(clientes);
				break;
				
			case VER_HOTELES_CON_SUS_HABITACIONES:
				ArrayList<Hotel> hoteles = HotelModelo.getHoteles();
				int idHotel = Formulario.pedirHotel(scan);
				ArrayList<Habitacion> habitaciones = HabitacionModelo.getHabitaciones(idHotel);
				ArrayList<Hotel> hotel = HotelModelo.getHotel(idHotel);
				Visor.mostrarHotel(hotel);
				Visor.mostrarHabitaciones(habitaciones);
				break;
				
			case REALIZAR_RESERVA:
				ArrayList<Hotel> hoteles1 = HotelModelo.getHoteles();
				Visor.mostrarHoteles(hoteles1);
				int idHotelReservar = Formulario.pedirHotel(scan);
				ArrayList<Habitacion> habitaciones1 = HabitacionModelo.getHabitaciones(idHotelReservar);
				Visor.mostrarHabitaciones(habitaciones1);
				int idHabitacion = Formulario.pedirHabitacion(scan);
				String idDni = Formulario.pedirDni(scan);
				Reserva reserva = Formulario.pedirFechaReserva(scan, idHabitacion, idDni);
				ReservaModelo.registrarReserva(reserva);
				break;
				
			case MODIFICAR_HABITACION:
				ArrayList<Habitacion> habitacion2 = HabitacionModelo.getHabitaciones();
				Visor.mostrarHabitaciones(habitacion2);
				int idHabitacionMod = Formulario.pedirHabitacion(scan);
				Habitacion idHabitacionMod2 = Formulario.pedirNuevosDatosHabitacion(scan);
				HabitacionModelo.modificarHabitacion(idHabitacionMod2, idHabitacionMod);
				break;
				
			case VER_RESERVAS:
				ArrayList<Hotel> hoteles2 = HotelModelo.getHoteles();
				Visor.mostrarHoteles(hoteles2);
				int idHotelRes = Formulario.pedirHotel(scan);
				int idHabitacionRes = HabitacionModelo.getHabitacionesRes(idHotelRes);
				ArrayList<Reserva> reservas = ReservaModelo.getReservas(idHabitacionRes);
				Visor.mostrarReserva(reservas);
				break;
				
			default:
				break;
			}
		}while(opcion != 0);
	}
}
