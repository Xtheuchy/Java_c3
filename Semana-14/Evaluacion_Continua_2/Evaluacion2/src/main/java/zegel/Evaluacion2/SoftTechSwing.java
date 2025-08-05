package zegel.Evaluacion2;

import com.formdev.flatlaf.FlatDarkLaf;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import zegel.Evaluacion2.gui.FormPantalla;

import javax.swing.*;

@SpringBootApplication
public class SoftTechSwing {
    public static void main(String[] args) {
        //Establecemos el modo oscuro
        FlatDarkLaf.setup();

        //A. intanciar la fabrica de Spring
        ConfigurableApplicationContext contextoSpring = new SpringApplicationBuilder(SoftTechSwing.class)
                .headless(false) //App escritorio
                .web(WebApplicationType.NONE) //No es web
                .run(args);
        //B. Luego que se cree toda la fabrica de spring
        SwingUtilities.invokeLater(()->{

            //Intanciar el formulario
            FormPantalla formulario = contextoSpring.getBean(FormPantalla.class);
            formulario.setVisible(true);
        });
    }
}
