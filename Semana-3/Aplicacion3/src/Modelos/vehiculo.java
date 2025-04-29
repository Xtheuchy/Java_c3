package Modelos;

public class vehiculo {
    //1.- Atributos
    private String modelo, color, numeroPlaca;
    private int nroPuertas,nroLlantas;
    
    //2.- Constructor
    public vehiculo(String modelo, String color, String numeroPlaca, int nroPuertas, int nroLlantas) {
        this.modelo = modelo;
        this.color = color;
        this.numeroPlaca = numeroPlaca;
        this.nroPuertas = nroPuertas;
        this.nroLlantas = nroLlantas;
    }
    
    //3.- Getter y Setter
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public int getNroPuertas() {
        return nroPuertas;
    }

    public void setNroPuertas(int nroPuertas) {
        this.nroPuertas = nroPuertas;
    }

    public int getNroLlantas() {
        return nroLlantas;
    }

    public void setNroLlantas(int nroLlantas) {
        this.nroLlantas = nroLlantas;
    }
    
    //4.- Metodos propios
    public void encender() {
    System.out.println("El vehículo está encendido.");
   }

    public void apagar() {
        System.out.println("El vehículo está apagado.");
    }
    
    //metodo toString
    @Override
    public String toString() {
        return "vehiculo{" + "modelo=" + modelo + ", color=" + color + ", numeroPlaca=" + numeroPlaca + ", nroPuertas=" + nroPuertas + ", nroLlantas=" + nroLlantas + '}';
    }
    
}
