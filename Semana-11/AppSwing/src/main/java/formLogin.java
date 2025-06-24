import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formLogin extends JFrame {
    private JPanel PanelPrincipal;

    public formLogin(){
        InicializadorPantalla();
    }


    private void InicializadorPantalla() {
        setContentPane(PanelPrincipal);
        setSize(600,400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        formLogin formulario = new formLogin();
        formulario.setVisible(true);
    }
}
