package Modelo;

public class Entrenador extends SeleccionFutbol{ 
    //1.- Atributos    
    protected  int idFederacion;
    protected int tiempoExperiencia;
    //2.- Contructor
    public Entrenador(int idFederacion, int tiempoExperiencia, int id, String nombre, String apellido, int edad) {
        super(id, nombre, apellido, edad);
        this.idFederacion = idFederacion;
        this.tiempoExperiencia = tiempoExperiencia;
    }
    //3.- Metodos Getter y Setter
    public int getIdFederacion() {
        return idFederacion;
    }

    public void setIdFederacion(int idFederacion) {
        this.idFederacion = idFederacion;
    }

    public int getTiempoExperiencia() {
        return tiempoExperiencia;
    }

    public void setTiempoExperiencia(int tiempoExperiencia) {
        this.tiempoExperiencia = tiempoExperiencia;
    }
    //4.- Metodos propios
    public void DirigirPartido(){
        
    }
    public void DirigirEntrenamiento(){
        
    }
    //5.- ToString
    @Override
    public String toString() {
        return "Entrenador{" + "idFederacion=" + idFederacion + ", tiempoExperiencia=" + tiempoExperiencia + '}';
    }
}
