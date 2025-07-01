package zegel.zona_fit;
/*
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
                 if(cliente!=null){
                     logger.info("Cliente encontrado" + cliente.toString() + nl);
                 }else{
                     logger.info(cliente + nl);
                 }
            }
            case 3 -> {
                logger.info("Agregar cliente");
                //a. Recibiendo datos
                logger.info("ingrese el nombre del cliente");
                String nombres = consola.next();
                logger.info("ingrese el Apellido del cliente");
                String apellidos = consola.next();
                logger.info("ingrese la membresia del cliente");
                Double membresia = Double.parseDouble(consola.next());
                //b. crear un objeto cliente
                Cliente cliente = new Cliente(null,nombres,apellidos,membresia);
                clienteServicio.guardarCliente(cliente);
                logger.info("Cliente correctamente agregado");
            }
            case 4 ->{
                logger.info("Modificar cliente");
                logger.info("Ingrese el id del cliente que desea modificar : ");
                int ClienteID = Integer.parseInt(consola.next());
                Cliente cliente = clienteServicio.buscarClientePorId(ClienteID);
                if(cliente!=null){
                    logger.info("ingrese el nombre del cliente");
                    String nombres = consola.next();
                    logger.info("ingrese el Apellido del cliente");
                    String apellidos = consola.next();
                    logger.info("ingrese la membresia del cliente");
                    Double membresia = Double.parseDouble(consola.next());
                    cliente = new Cliente(ClienteID,nombres,apellidos,membresia);
                    clienteServicio.guardarCliente(cliente);
                    logger.info("Cliente actualizado");
                }
                else {
                    logger.info("Error ese id no pertenece a ningun cliente");
                }
            }
            case 5 -> {
                logger.info("Elimnar cliente");
                logger.info("Ingrese el id del cliente que desea Eliminar : ");
                int ClienteID = Integer.parseInt(consola.next());
                Cliente cliente = clienteServicio.buscarClientePorId(ClienteID);
                if(cliente!=null){
                    clienteServicio.eliminarCliente(cliente);
                    logger.info("Cliente eliminado");
                }else {
                    logger.info("Cliente con id " + ClienteID + "No existe");
                }
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
                3. Agregar cliente 
                4. Modificar Cliente
                5. Eliminar Cliente
                6. Salir
                Elige una opción
                """);
        var opcion = Integer.parseInt(consola.next());
        return opcion;
    }
}
*/