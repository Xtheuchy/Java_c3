package Modelos;

public class usuario {
    //1.- Atrubutos
    private String nombre;
    private int edad;
    
    //2.- Constructor
    public usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    //3.- metodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    //4.- Metodo toString
    @Override
    public String toString() {
        return "usuario{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }
   
}
