package Modelos;

public class Empleado {
    //1.- Atributos (Caracteristicas)
    
    //Encapsulamiento (Proteger datos - private)
    
    private String nombre,edad;
    private double sueldo;
    
    //2.- Constructor
    
    public Empleado(String nombre, String edad, double sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }
    
    //3.- Getter y Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    //4.- ToString --> Muestra toda la info del objeto.
    
    @Override 
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + '}';
    }
    
}
