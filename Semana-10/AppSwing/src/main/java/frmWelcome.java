import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class frmWelcome extends JFrame {
    private JPanel panel1;
    public frmWelcome(){
        //Llamar a un programa que tendra la configuracion inicial
        inicializarFormulario();
    }
    //3.- Tendra las configuraciones iniciales del form
    private void inicializarFormulario() {
        setContentPane(panel1);//Contenedor principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400); //Ancho y alto del form
        setLocationRelativeTo(null); //Ubicacion centrado
    }
    //4.- Crear el metodo de inicio
    public static void main(String[] args) {
        //Cambiar el aspecto del formulario  (modo oscuro)
        FlatDarculaLaf.setup();
        //a. Crear un objeto de la clase frWelcome
        frmWelcome formulario = new frmWelcome();
        //b. Mostrar formulario
        formulario.setVisible(true);
    }
}
