package Modelos;
public class Alumno extends usuario{
    //1.- Atributos
    private String correo,apoderado;
    
    //2.- Constructor

    public Alumno(String correo, String apoderado, String nombre, int edad) {
        super(nombre, edad);
        this.correo = correo;
        this.apoderado = apoderado;
    }
    
    //3.- Getter y Setter
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApoderado() {
        return apoderado;
    }

    public void setApoderado(String apoderado) {
        this.apoderado = apoderado;
    }
    //4.- Metodo publico
    public void Modificar(){
        System.out.println("Alumno modificado");
    }
    
    //5.- ToString
    @Override
    public String toString() {
        return "Alumno{" + "Nombre = " + super.getNombre() + " correo=" + correo + ", apoderado=" + apoderado + '}';
    }
    
}
