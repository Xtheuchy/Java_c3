package zegel.zona_fit;

/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zegel.zona_fit.modelo.Cliente;
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
		logger.info("****Aplicación Finalizada****");
	}

	@Override
	public void run(String... args) throws Exception {
		//Llamado al programa principal
		zonaFitApp();
	}

	private void zonaFitApp(){
		logger.info("----  Aplicación Zona Fit  ---------");
		var salir=false;
		var consola = new Scanner(System.in);
		//Si el estado de salir es "true" entonces mostrar las opciones
		while (!salir){
				var opcion = mostrarMenu(consola);
				//Supuestamente retorno el #1.
				//Llamar al otro programa
				salir	= ejecutarOpciones(consola,opcion);

				logger.info(nl);
		}
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion) {
		var salir=false;
			switch (opcion) {
				case 1 -> {
					logger.info("Listado de Clientes ");
					List<Cliente> clientes = clienteServicio.listarClientes();
					clientes.forEach(cliente -> logger.info(cliente.toString()));
				}
				case 2 ->{
					logger.info("El cliente por el id es: ...");
					logger.info("Id del cliente a buscar");
					var idCliente = Integer.parseInt(consola.next());
					//Crear un objeto que reciba la info del cliente encontrado
					Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
					//Mostrar los datos en pantalla
					if (cliente!=null)
						logger.info("Cliente encontrado "+cliente + nl);
					else
						logger.info(cliente+nl);
				}
				case 3->{
					logger.info("Agregar al cliente"+nl);
					//a. Recibiendo los datos desde la consola
					logger.info("Nombre: ");
					var nombre = consola.next();
					logger.info("Apellido: ");
					var apellido = consola.next();
					logger.info("Membresia");
					var membresia = Integer.parseInt(consola.next());
					//b. Crear un objeto  "cliente" esta sin datos
					var cliente = new Cliente();
					//c. Setter puedes asignarle valores
					cliente.setNombres(nombre);
					cliente.setApellidos(apellido);
					cliente.setMembresia(membresia);
					//d. ya tenemos el objeto con datos, guardar en la BD
					clienteServicio.guardarCliente(cliente);
					logger.info("Cliente agregado " + cliente + nl);
				}
				case 4->{
					logger.info("Actualizar al cliente"+nl);
					//a. Recibiendo los datos desde la consola
					//Necesitamos al código
					logger.info("Ingrese el id Cliente: ");
					var idCliente = Integer.parseInt(consola.next());
					//b. Crear un objeto con el código
					Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
					//c. evaluar si el cliente tiene datos
					if (cliente!=null) {
						logger.info("Nombre: ");
						var nombre = consola.next();
						logger.info("Apellido: ");
						var apellido = consola.next();
						logger.info("Membresia");
						var membresia = Integer.parseInt(consola.next());
						//c. Setter puedes asignarle valores
						cliente.setNombres(nombre);
						cliente.setApellidos(apellido);
						cliente.setMembresia(membresia);
						//d. ya tenemos el objeto con datos, guardar en la BD
						clienteServicio.guardarCliente(cliente);
						logger.info("Cliente actualizado " + cliente + nl);
					}
				}
				case 5->{
					logger.info("Aliminar Cliente ");
					logger.info("Ingrese id Cliente: ");
					var idClie  = Integer.parseInt(consola.next());
					Cliente cliente  = clienteServicio.buscarClientePorId(idClie);
					if (cliente!=null){
						clienteServicio.eliminarCliente(cliente);
						logger.info("Cliente eliminado");
					}else{
						logger.info("El cliente no esta en la BD");
					}

				}
				case 6->{
					logger.info("Hasta pronto!");
					salir=true;
				}
			}
		return  salir;
	}



	private int mostrarMenu(Scanner consola) {
		logger.info("""
			 	**** Menú de Opciones ****
			 	1. Listar Clientes
			 	2. Buscar Cliente
			 	3. Agregar Cliente
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

