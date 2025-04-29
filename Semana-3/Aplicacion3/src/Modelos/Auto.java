package Modelos;

public class Auto extends vehiculo {
    private String tipoAuto; 

    // Constructor
    public Auto(String modelo, String color, String numeroPlaca, int nroPuertas, int nroLlantas, String tipoAuto) {
        super(modelo, color, numeroPlaca, nroPuertas, nroLlantas);
        this.tipoAuto = tipoAuto;
    }

    // Getter y Setter
    public String getTipoAuto() {
        return tipoAuto;
    }

    public void setTipoAuto(String tipoAuto) {
        this.tipoAuto = tipoAuto;
    }

    // Método propio
    public void mostrarTipo() {
        System.out.println("Este auto es de tipo: " + tipoAuto);
    }

    @Override
    public String toString() {
        return super.toString() + ", tipoAuto=" + tipoAuto;
    }
}
