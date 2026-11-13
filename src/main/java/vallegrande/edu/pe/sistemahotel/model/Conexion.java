package vallegrande.edu.pe.sistemahotel.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/db_hotel?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConexion() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a MySQL (db_hotel)");
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return con;
    }
}
