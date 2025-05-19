package datos;
//1.- Importar librerias
import dominio.Cliente; //Nuestro
import java.util.List; //JDBC --> Conexion a BD
public interface IClienteDAO {
    //Operaciones a los clientes
    List<Cliente> ListarClientes();
    
    Cliente BuscarClientesPorId(int id);
    boolean AgregarCliente(Cliente cliente);
    boolean ModificarCliente(Cliente cliente);
    boolean EliminarCliente(int id);
    
    //Describir a las operaciones
    //No esta la implemetación
}
