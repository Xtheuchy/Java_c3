package Modelos;

public class Facilitador extends usuario{
    //1.- Atributos 
    private String carrera;
    private double sueldo;
    
    //2.- Constructor
    public Facilitador(String carrera, double sueldo, String nombre, int edad) {
        super(nombre, edad);
        this.carrera = carrera;
        this.sueldo = sueldo;
    }
    
    //3.- Getter y Setter
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    //4.- Metodo publico 
    public void Darde_Baja(){
        System.out.println("Se dio de baja");
    }
    
    //5.- ToString
    @Override
    public String toString() {
        return "Facilitador{" + "carrera=" + carrera + ", sueldo=" + sueldo + '}';
    }
}
