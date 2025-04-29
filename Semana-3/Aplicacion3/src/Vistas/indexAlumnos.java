package Vistas;
//1.- Importar las librerias
import Modelos.*;

public class indexAlumnos {

    public static void main(String[] args) {
        //1.- Crear objetos
        Alumno victor = new Alumno("victor@gmail.com","a","Melagarejo", 19);
        Alumno lucas = new Alumno("lucas@gmail,com","b","Cruz", 20);
        
        //1.1.Agrega a 2 profesores
        Facilitador yolfer = new Facilitador("backEnd", 250,"Yolfer", 25);
        Facilitador jose = new Facilitador("Base de Datos", 240, "José", 30);
        
        //2.- Acceder a los datos set(establecer)---> Modificar dato
        lucas.setEdad(18);
        
        //3.- Mostrar datos get(Mostrar)
        System.out.println(victor.toString());
        System.out.println(lucas.toString());
    }
    
}
