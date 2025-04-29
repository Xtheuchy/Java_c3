package Modelos;

public class Camion extends vehiculo {
    // Atributo de Camion
    private double capacidadCarga; // en toneladas

    // Constructor
    public Camion(double capacidadCarga, String modelo, String color, String numeroPlaca, int nroPuertas, int nroLlantas) {    
        super(modelo, color, numeroPlaca, nroPuertas, nroLlantas);
        this.capacidadCarga = capacidadCarga;
    }
    // Getter y Setter
    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    // Metodo propio
    public void cargar(double peso) {
        if (peso <= capacidadCarga) {
            System.out.println("Cargando " + peso + " toneladas.");
        } else {
            System.out.println("Peso excede la capacidad maxima de carga.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", capacidadCarga=" + capacidadCarga + " toneladas";
    }
}
