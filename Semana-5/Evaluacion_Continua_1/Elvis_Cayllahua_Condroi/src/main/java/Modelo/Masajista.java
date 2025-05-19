package Modelo;
public class Masajista extends SeleccionFutbol{
    //1.- Atributos
    protected String titulacion;
    protected String especialidad;
    protected int tiempoExperiencia;
    //2.- Constructor
    public Masajista(String titulacion, String especialidad, int tiempoExperiencia, int id, String nombre, String apellido, int edad) {
        super(id, nombre, apellido, edad);
        this.titulacion = titulacion;
        this.especialidad = especialidad;
        this.tiempoExperiencia = tiempoExperiencia;
    }
    //3.-Metodos Getter y Setter
    public String getTitulacion() {
        return titulacion;
    }
    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getTiempoExperiencia() {
        return tiempoExperiencia;
    }

    public void setTiempoExperiencia(int tiempoExperiencia) {
        this.tiempoExperiencia = tiempoExperiencia;
    }
    //4.- Metodos propios
    public void darMasaje(){
        System.out.println("");
    }
    //5.- Metodo ToString
    @Override
    public String toString() {
        return "Masajista{" + "titulacion=" + titulacion + ", especialidad=" + especialidad + ", tiempoExperiencia=" + tiempoExperiencia + '}';
    }
    
}
