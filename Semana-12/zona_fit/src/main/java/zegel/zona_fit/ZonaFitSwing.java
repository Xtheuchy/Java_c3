package zegel.zona_fit;

import com.formdev.flatlaf.FlatDarkLaf;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import zegel.zona_fit.gui.frmZonaFit;

import javax.swing.*;

//1. Agregar la notación
@SpringBootApplication //Forma parte de springBoot
public class ZonaFitSwing{
    //2. Crear metodo de incio
    public static void main(String[] args) {
        //Estableciendo el Modo oscuro
        FlatDarkLaf.setup();
        //a. Instanciar la Frabica de Spring
        ConfigurableApplicationContext contextoSpring = new SpringApplicationBuilder(ZonaFitSwing.class)
                .headless(false) //App de escritorio
                .web(WebApplicationType.NONE) //No es web
                .run(args);
        //B. Luego que se crea toda la frabrica de spring
        SwingUtilities.invokeLater(()->{
            //Intancia al formulario
            frmZonaFit formulario = contextoSpring.getBean(frmZonaFit.class);
            formulario.setVisible(true);
        });
    }
}