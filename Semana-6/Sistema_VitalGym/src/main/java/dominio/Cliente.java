package dominio;

public class Cliente {
    //1.- Atributos
    private int id;
    private String nombres,apellidos;
    private double membresia;
    
    //2.- Constuctores
    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(String nombres, String apellidos, double membresia) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.membresia = membresia;
    }

    public Cliente(int id, String nombres, String apellidos, double membresia) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.membresia = membresia;
    }
    
    //3.- Metodos getter(obtener) y setter(asignar)
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
    //4.- ToString
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", membresia=" + membresia + '}';
    }
    
}
