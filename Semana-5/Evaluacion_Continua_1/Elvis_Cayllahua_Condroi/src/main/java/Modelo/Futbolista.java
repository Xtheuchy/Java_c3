package Modelo;
public class Futbolista extends SeleccionFutbol{ 
    //1.- Atributos
    protected String posicion;
    protected int nroCamiseta;
    protected String club;
    //2.- Constructor
    public Futbolista(String posicion, int nroCamiseta, String club, int id, String nombre, String apellido, int edad) {
        super(id, nombre, apellido, edad);
        this.posicion = posicion;
        this.nroCamiseta = nroCamiseta;
        this.club = club;
    }
    //3.- Metodos Getter y Setter 
    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNroCamiseta() {
        return nroCamiseta;
    }

    public void setNroCamiseta(int nroCamiseta) {
        this.nroCamiseta = nroCamiseta;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
    //4.- Metodos propios
    public void JugarPartido(){
        System.out.println("");
    }
    public void Entrenar(){
        System.out.println("");
    }
}
