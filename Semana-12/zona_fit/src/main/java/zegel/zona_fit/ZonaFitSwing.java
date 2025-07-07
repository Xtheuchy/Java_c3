package zegel.zona_fit;

import com.formdev.flatlaf.FlatDarculaLaf;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import zegel.zona_fit.gui.frmZonaFit;

import javax.swing.*;

//1. Agregar la Notación
@SpringBootApplication  //Forma parte de Spring boot
public class ZonaFitSwing {
    //2. Crear un Metodo de Inicio
    public static void main(String[] args) {
        //Establecer el Modo Oscuro
        FlatDarculaLaf.setup();

        //a. Instanciar la Fabrica de Spring
        ConfigurableApplicationContext  contextoSpring = new SpringApplicationBuilder(ZonaFitSwing.class)
                .headless(false)  //App de escritorio
                .web(WebApplicationType.NONE) //No es Web
                .run(args);

        //B. Luego que se crea toda la fabrica de Spring
        SwingUtilities.invokeLater(() ->{

            //Instanciar al formulario
            frmZonaFit  formulario = contextoSpring.getBean(frmZonaFit.class);
            formulario.setVisible(true);
        });
    }
}
