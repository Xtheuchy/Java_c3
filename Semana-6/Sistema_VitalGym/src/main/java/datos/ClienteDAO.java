package datos;
//1.- Importar Librerias
import dominio.Cliente;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class ClienteDAO implements IClienteDAO{
    @Override
    public List<Cliente> ListarClientes() {
        //Crear un array de datos
        List<Cliente> clientes = new ArrayList<>();
        //Traer los datos de la BD
        try {
            //Conexion a la base de datos
            Connection con = Conexion.Conexion.getConexion();
            //Preparar consulta
            PreparedStatement pst = con.prepareCall("select * from cliente");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                var cliente = new Cliente(); //Crear un objeto
                cliente.setId(rs.getInt("id"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setMembresia(rs.getDouble("membresia"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al listar cliente " + e.getMessage());
        }
        return clientes;
    }

    @Override
    public boolean BuscarClientesPorId(Cliente cliente) {
        try {
            Connection con = Conexion.Conexion.getConexion();
            var sql = "select * from cliente where id=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getId());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setMembresia(rs.getDouble("membresia"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al buscar cliente"+ e.getMessage());
        }
        return false;
    };
    @Override
    public boolean AgregarCliente(Cliente cliente) {
       boolean agregado = false;
        try {
            Connection con = Conexion.Conexion.getConexion();
            //Consulta
            String sql = "INSERT INTO cliente(id, nombres, apellidos, membresia) VALUES (null, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNombres());
            pst.setString(2,cliente.getApellidos());
            pst.setDouble(3, cliente.getMembresia());
           int filasafectadas = pst.executeUpdate();
           agregado = filasafectadas>0;
        } catch (Exception e) {
            System.out.println("Error al agregar cliente " + e.getMessage());
        }
        return agregado;
    }

    @Override
    public boolean ModificarCliente(Cliente cliente) {
        try {
            Connection con = Conexion.Conexion.getConexion();
            var sql = "update cliente set nombres=?, apellidos=?,membresia=? where id=? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNombres());
            pst.setString(2, cliente.getApellidos());
            pst.setDouble(3, cliente.getMembresia());
            pst.setInt(4, cliente.getId());
            pst.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al actualizar cliente" + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean EliminarCliente(Cliente cliente) {
        try {
            Connection con = Conexion.Conexion.getConexion();
            //Consulta 
            String sql = "delete from cliente where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getId());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    //vamos a hacer una prueba:)
    //frondEnd
    public static void main(String[] args) {
        //Supuestamente es una web..
        //System.out.println("Listado de clientes");
        //Crear un objeto de interfaz
        //para usar los metodos
        //IClienteDAO clienteDao = new ClienteDAO();
        //Simplificar 
        //var clientes = clienteDao.ListarClientes();
        
        //2.- Busqueda por id
        /*IClienteDAO clienteDao = new  ClienteDAO();
        Cliente cliente = new Cliente(5);
        var encontrado = clienteDao.BuscarClientesPorId(cliente);
        if(encontrado){
            System.out.println("Cliente encontrado " + cliente);
        }
        else{
            System.out.println("No se encontro al cliente " + cliente.getId());
        }*/
        
        
        
        
        //3.- Agregar cliente
        /*IClienteDAO clienteDao = new  ClienteDAO(); //Crear un objeto de la interfas
        Cliente cliente = new Cliente("Jael","Jimenez",550);//Crear un objeto cliente
        var nuevo = clienteDao.AgregarCliente(cliente);
        if(nuevo){
            System.out.println("Cliente insertado " + cliente);
        }
        else{
            System.out.println("No se pudo insertar cliente" + cliente);
        }*/
        //3.- Modificar cliente
        /*IClienteDAO clienteDao = new  ClienteDAO(); //Crear un objeto de la interfas
        Cliente cliente = new Cliente(5,"Jael Nicol","Jimenez",600);//Crear un objeto cliente
        var modificado = clienteDao.ModificarCliente(cliente);
        if(modificado){
            System.out.println("Cliente modificado" + cliente);
        }
        else{
            System.out.println("No se pudo modificar cliente" + cliente);
        }*/
        //Eliminar cliente
        ClienteDAO clienteDao = new ClienteDAO();
        var cliente = new Cliente(1);
        var eliminado = clienteDao.EliminarCliente(cliente);
        if(eliminado){
            System.out.println("Cliente eliminado : " + cliente);
        }
        else{
            System.out.println("No se pudo eliminar cliente " + cliente);
        }
        
        
    }
}
