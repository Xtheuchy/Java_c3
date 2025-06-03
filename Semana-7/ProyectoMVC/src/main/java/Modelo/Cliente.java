package Modelo;
public class Cliente {
    //Atributos
    private int id;
    private String nombres,apellidos;
    private double membresia;
    
    //Creamos Constructores
    public Cliente() { //Crea un cliente sin datos
    }

    public Cliente(int id) {
        this.id = id;
    }
    
    public Cliente(String nombres, String apellidos, double membresia) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.membresia = membresia;
    }
    
    public Cliente(int id, String nombres) {
        this.id = id;
        this.nombres = nombres;
    }
    public Cliente(int id, String nombres, String apellidos, double membresia) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.membresia = membresia;
    }
    //Metodos GETTER Y SETTER
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getMembresia() {
        return membresia;
    }
    public void setMembresia(double membresia) {
        this.membresia = membresia;
    }
    //Metodo ToString --> Mostrar todos los datos del objeto
    @Override //-->Indica que existia pero lo estamos sobreescribiendo
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", membresia=" + membresia + '}';
    }
}
