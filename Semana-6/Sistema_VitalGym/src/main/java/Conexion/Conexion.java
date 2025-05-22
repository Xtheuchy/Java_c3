package Conexion;
//1.- Importar Librerias
import java.sql.*;

public class Conexion {
      //2.Crear programa traeConexion
    public static Connection getConexion(){
        Connection conexion=null;
        var basedatos="vitalgym";
        var usuario="root";
        var password="";
        var url="jdbc:mysql://localhost:3306/"+basedatos;
        //Aquí vamos a conectarnos a la base de datos
        try {///Prueba un código
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,password);
        } catch (Exception e) {
            System.out.println("Error de conexion "+ e.getMessage());
        }
        return conexion;
    }
    
    //En esta zona vamos a probar conexion
    public static void main(String[] args) {
        var conexion = Conexion.getConexion();
        
        if(conexion!=null){
            System.out.println("Conexion exitosa");
        }
        else{
            System.out.println("Conexion Errada");
        }
    }
}
