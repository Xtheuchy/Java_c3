package Vistas;
//1.- Importar libreria
import Modelos.Empleado;
public class indexEmpleado {

    public static void main(String[] args) {
        //1.- Crear objetos
        Empleado Paul = new  Empleado("Zapata");
        Empleado Leonardo = new Empleado("Leonardo","20", 300);
        
        //2.- Los datos del objeto se puede modificar
        //? Se obtiene con los metodos setter        
        Paul.setEdad("25");
        
        //3.- Mostrar los datos Get :)  toString()
        System.out.println(Paul.toString());
        System.out.println(Leonardo.toString());
    }
    
}
