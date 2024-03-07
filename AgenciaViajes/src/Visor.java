import java.util.ArrayList;

public class Visor {
	
	public static void menu() {
		System.out.println(App.SALIR+"- Salir \n"
				+ App.REGISTRAR_CLIENTE+"- Registrar cliente \n"
				+ App.VER_CLIENTES+"- Ver clientes \n"
				+ App.VER_HOTELES_CON_SUS_HABITACIONES+"- Ver hotel con sus habitaciones \n"
				+ App.REALIZAR_RESERVA+"- Realizar reserva \n"
				+ App.MODIFICAR_HABITACION+"- Modificar habitacion \n"
				+ App.VER_RESERVAS+"- Ver reservas");
	}

	public static void mostrarClientes(ArrayList<Cliente> cliente) {
		for (Cliente cliente1 : cliente) {
			System.out.println(cliente1);
		}
	}
	
	public static void mostrarHabitaciones(ArrayList<Habitacion> habitacion) {
		for (Habitacion habitacion1 : habitacion) {
			System.out.println(habitacion1);
		}
	}

	public static void mostrarHoteles(ArrayList<Hotel> hotel) {
		for (Hotel hotel1 : hotel) {
			System.out.println(hotel1);
		}
	}

	public static void mostrarHotel(ArrayList<Hotel> hotel) {
		for (Hotel hotel1 : hotel) {
			System.out.println(hotel1);
		}
	}

	public static void mostrarReserva(ArrayList<Reserva> reservas) {
		for (Reserva reserva : reservas) {
			System.out.println(reserva);
		}
		
	}
}
