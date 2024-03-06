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

	public static void run() throws ParseException {
		
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
				GestorBBDD.registrarCliente(cliente);
				break;
				
			case VER_CLIENTES:
				ArrayList<Cliente> clientes = GestorBBDD.getClientes();
				Visor.mostrarClientes(clientes);
				break;
				
			case VER_HOTELES_CON_SUS_HABITACIONES:
				ArrayList<Hotel> hoteles = GestorBBDD.getHoteles();
				int idHotel = Formulario.pedirHotel(scan);
				ArrayList<Habitacion> habitaciones = GestorBBDD.getHabitaciones(idHotel);
				Visor.mostrarHabitaciones(habitaciones);
				break;
				
			case REALIZAR_RESERVA:
				ArrayList<Hotel> hoteles1 = GestorBBDD.getHoteles();
				Visor.mostrarHoteles(hoteles1);
				int idHotel1 = Formulario.pedirHotel(scan);
				ArrayList<Habitacion> habitaciones1 = GestorBBDD.getHabitaciones(idHotel1);
				Visor.mostrarHabitaciones(habitaciones1);
				int idHabitacion = Formulario.pedirHabitacion(scan);
				String idDni = Formulario.pedirDni(scan);
				Reserva reserva = Formulario.pedirFechaReserva(scan, idHabitacion, idDni);
				GestorBBDD.registrarReserva(reserva);
				break;
				
			case MODIFICAR_HABITACION:
				ArrayList<Habitacion> habitacion2 = GestorBBDD.getHabitacionesMod();
				Visor.mostrarHabitaciones(habitacion2);
				int idHabitacionMod = Formulario.pedirHabitacion(scan);
				Habitacion idHabitacionMod2 = Formulario.pedirNuevosDatosHabitacion(scan);
				GestorBBDD.modificarHabitacion(idHabitacionMod2, idHabitacionMod);
				break;
			default:
				break;
			}
		}while(opcion != 0);
	}
}
