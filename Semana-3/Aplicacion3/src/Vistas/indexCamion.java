package Vistas;
import Modelos.Camion;
public class indexCamion {

    public static void main(String[] args) {
         Camion camion1 = new Camion(15.0, "Volvo FM", "Azul", "XYZ-456", 2, 6);
        
        // Mostrar los detalles del Camion
        System.out.println(camion1.toString());
        
        // Realizar una carga
        camion1.cargar(12.0); 
        camion1.cargar(20.0);
    }
    
}
