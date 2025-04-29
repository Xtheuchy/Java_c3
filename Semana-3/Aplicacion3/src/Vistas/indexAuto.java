package Vistas;
import Modelos.Auto;
public class indexAuto {

    public static void main(String[] args) {
    Auto Auto1 = new Auto("Toyota Corolla", "Rojo", "ABC-123", 4, 4, "Sedan");
    
        System.out.println(Auto1.toString());
    }
    
}
