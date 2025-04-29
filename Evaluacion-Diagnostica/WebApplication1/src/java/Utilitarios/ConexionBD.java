package Utilitarios;

import java.sql.*;
public class ConexionBD {
    public static Connection retornaConexion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/evaluacion","root","12345");
            
        } catch (Exception e) {
            System.out.println("Error de conexio " + e);
        }
        return cn;
    }
    
}
