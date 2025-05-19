package Vista;
// Importamos la clase Scanner para leer datos del usuario
import java.util.Scanner;
// Importamos todas las clases del paquete Modelo
import Modelo.*;
//Importamos ArrayList para almacenar los datos
import java.util.ArrayList;
public class GestorSeleccionFutbol {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer datos desde el teclado
        Scanner tec = new Scanner(System.in);
        ArrayList<Entrenador> Entrenadores= new ArrayList<>();
        ArrayList<Futbolista> Jugadores = new ArrayList<>();
        ArrayList<Masajista> Masajistas = new ArrayList<>();
         String op;
        System.out.println("""
                           =================================
                            Gestion de la seleccion de futbol
                           =================================""");
        while (true) {            
            System.out.print("""
                               Ingrese una opcion :
                               [1] Gestion de Jugadores
                               [2] Gestion de Entrenadores
                               [3] Gestion de Masajistas
                               [4] Salir """);
            op = tec.nextLine();
            if(op.equals("1")){
                while (true) {                    
                    System.out.print("""
                               Ingrese una opcion :
                               [1] Listar Jugadores
                               [2] Buscar Jugador
                               [3] Insertar jugador
                               [4] Salir""");
                   op = tec.nextLine();
                   if(op.equals("4")){
                        System.out.println("Hasta pronto");
                       break;
                   }
                    switch (op) {
                        case "1":
                            System.out.println("""
                                               Jugardores
                                               ===============""");
                            for(Futbolista jugador : Jugadores){
                                System.out.println(jugador);
                            }
                            break;
                         case "2":
                            System.out.print("Ingrese el nombre del jugador a buscar: ");
                            String nombreBuscado = tec.nextLine();

                            boolean encontrado = false;
                            for (Futbolista jugador : Jugadores) {
                                if (jugador.getNombre().equalsIgnoreCase(nombreBuscado)) {
                                    System.out.println("Jugador encontrado: " + jugador.getNombre() + " " + jugador.getApellido());
                                    encontrado = true;
                                    break;
                                }
                            }
                            if (!encontrado) {
                                System.out.println("No se encontró un jugador con ese nombre.");
                            }
                            break;
                        case "3":
                            System.out.println("Completar lo siguiente");
                            System.out.print("Posicion : ");
                            String posicion = tec.nextLine();
                            System.out.print("Numero de la camisa : ");
                            int nrocamisa = tec.nextInt();
                            tec.nextLine();
                            System.out.print("Club : ");
                            String club = tec.nextLine();
                            System.out.print("Numero identificador: ");
                            int id = tec.nextInt();
                            tec.nextLine();
                            System.out.print("Nombre : ");
                            String nombre = tec.nextLine();
                            System.out.print("Apellido : ");
                            String apellido = tec.nextLine();
                            System.out.print("Edad del Jugador : ");
                            int edad = tec.nextInt();                            
                            Futbolista jugador = new Futbolista(posicion, nrocamisa, club, id, nombre, apellido, edad);
                            Jugadores.add(jugador);
                            System.out.println("Jugador Agregado!!");
                            break;
                    }
                }
            }
            else if(op.equals("2")){
                while (true) {                    
                    System.out.print("""
                               Ingrese una opcion :
                               [1] Listar Entrenadores
                               [2] Buscar Entrenador
                               [3] Insertar Entrenador
                               [4] Salir""");
                   op = tec.nextLine();
                   if(op.equals("4")){
                        System.out.println("Hasta pronto");
                       break;
                   }
                    switch (op) {
                        case "1":
                            System.out.println("""
                                               Entrenadores
                                               ===============""");
                            for(Entrenador Entrenador : Entrenadores){
                                System.out.println(Entrenador);
                            }
                            break;
                         case "2":
                            System.out.print("Ingrese el nombre del Entrenador a buscar: ");
                            String nombreBuscado = tec.nextLine();

                            boolean encontrado = false;
                            for (Entrenador Entrenador : Entrenadores) {
                                if (Entrenador.getNombre().equalsIgnoreCase(nombreBuscado)) {
                                    System.out.println("Entrenador encontrado: " + Entrenador.getNombre() + " " + Entrenador.getApellido());
                                    encontrado = true;
                                    break;
                                }
                            }
                            if (!encontrado) {
                                System.out.println("No se encontró un Entrenador con ese nombre.");
                            }
                            break;
                        case "3":
                            System.out.println("Completar lo siguiente");
                            System.out.print("Identificador de la Federacion (id) : ");
                            int idFederacion = tec.nextInt();
                            tec.nextLine();
                            System.out.print("Tiempo de experiencia : ");
                            int tiempoExperiencia = tec.nextInt();
                            tec.nextLine();
                            System.out.print("ID entrenador: ");
                            int id = tec.nextInt();
                            tec.nextLine();
                            System.out.print("Nombre : ");
                            String nombre = tec.nextLine();
                            System.out.print("Apellido : ");
                            String apellido = tec.nextLine();
                            System.out.print("Edad del Entrenador : ");
                            int edad = tec.nextInt();                            
                            Entrenador entrenador = new Entrenador(idFederacion, tiempoExperiencia, id, nombre, apellido, edad);
                            Entrenadores.add(entrenador);
                            System.out.println("Entrenador Agregado!!");
                            break;
                    }
                }
            }
            else if(op.equals("3")){
                while (true) {                    
                    System.out.print("""
                               Ingrese una opcion :
                               [1] Listar Masajistas
                               [2] Buscar Masajista
                               [3] Insertar Masajista
                               [4] Salir""");
                   op = tec.nextLine();
                   if(op.equals("4")){
                        System.out.println("Hasta pronto");
                       break;
                   }
                    switch (op) {
                        case "1":
                            System.out.println("""
                                               Masajistas
                                               ===============""");
                            for(Masajista masajista : Masajistas){
                                System.out.println(masajista);
                            }
                            break;
                         case "2":
                            System.out.print("Ingrese el nombre del Masajista a buscar: ");
                            String nombreBuscado = tec.nextLine();

                            boolean encontrado = false;
                            for (Masajista masajista : Masajistas) {
                                if (masajista.getNombre().equalsIgnoreCase(nombreBuscado)) {
                                    System.out.println("Masajista encontrado: " + masajista.getNombre() + " " + masajista.getApellido());
                                    encontrado = true;
                                    break;
                                }
                            }
                            if (!encontrado) {
                                System.out.println("No se encontró un Masajista con ese nombre.");
                            }
                            break;
                        case "3":
                            System.out.println("Completar lo siguiente");
                            System.out.print("Titulacion : ");
                            String titulacion = tec.nextLine();
                            System.out.print("Especialidad : ");
                            String especialidad = tec.nextLine();
                            System.out.print("Tiempo de experiencia : ");
                            int tiempoExp = tec.nextInt();
                            tec.nextLine();
                            System.out.print("ID Masajista: ");
                            int id = tec.nextInt();
                            tec.nextLine();
                            System.out.print("Nombre : ");
                            String nombre = tec.nextLine();
                            System.out.print("Apellido : ");
                            String apellido = tec.nextLine();
                            System.out.print("Edad del Masajista : ");
                            int edad = tec.nextInt();                        
                            Masajista masajista = new Masajista(titulacion,especialidad, tiempoExp,id, nombre,apellido, edad);
                            Masajistas.add(masajista);
                            System.out.println("Masajista Agregado!!");
                            break;
                    }
                }
            }
            else{
                System.out.println("Verifique el numero");
                System.out.println("Hasta pronto");
                break;
            }
        }
    }
}
