import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

	protected static Connection cn = null;
	
	private final static String host = "localhost";
	private final static String BBDD = "agenciadeviajes";
	private final static String usuario = "root";
	private final static String contrasenia = "";
	
	public static Connection conectar() {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection("jdbc:mysql://" + host + "/" +BBDD,usuario,contrasenia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	public static void cerrar() {
		
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getters() {
		
	}
	
	public void setters() {
		
	}
}
