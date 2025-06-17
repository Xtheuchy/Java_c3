package zegel.zona_fit;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zegel.zona_fit.modelo.Cliente;
import zegel.zona_fit.servicio.ClienteServicio;
import zegel.zona_fit.servicio.IClienteServicio;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {
    //Inyectar dependencias
    @Autowired
    private IClienteServicio clienteServicio;
    String nl = System.lineSeparator();
    private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);
    public static void main(String[] args) {
        logger.info("****Aplicación iniciada****");
        SpringApplication.run(ZonaFitApplication.class, args);
        logger.info("****Aplicación finalizada****");


    }

    @Override
    public void run(String... args) throws Exception {
        //Llamado al programa princiapl
        zonaFitApp();
    }

    private void zonaFitApp(){
        logger.info("====== Aplicación Zona fit ======");
        var salir = false;
        var consola = new Scanner(System.in);
        //Si el estado de salir es true entonces mostrar opciones
        while(!salir){
            var opcion = mostrarMenu(consola);
            //
            salir = ejecutarOpciones(consola, opcion);
            logger.info(nl);
        }
    }

    private boolean ejecutarOpciones(Scanner consola, int opcion) {
        var salir = false;
        switch (opcion){
            case 1 -> {
                logger.info("Listado de clientes");
                List<Cliente> clientes = clienteServicio.listarClientes();
                clientes.forEach(cliente -> logger.info(cliente.toString()));
            }
            case 2 -> {
                 logger.info("Ingrese el id del cliente a buscar : ");
                 int clienteID = Integer.parseInt(consola.next());
                 Cliente cliente = clienteServicio.buscarClientePorId(clienteID);
                 logger.info("El cliente con id : " + clienteID + " es : ");
                 logger.info(cliente.toString());
            }
            case 6 -> {
                logger.info("Hasta pronto!!");
                salir = true;
            }
        }
        return salir;
    }

    private int mostrarMenu(Scanner consola) {
        logger.info("""
                *** Menú de opciones  ***
                1. Listar Clientes
                2. Buscar Cliente
                3. Agregar cliente Modificar Cliente
                5. Eliminar Cliente
                6. Salir
                Elige una opción
                """);
        var opcion = Integer.parseInt(consola.next());
        return opcion;
    }
}
