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
    public Cliente BuscarClientesPorId(int id) {
        Cliente cliente = null;
        try {
            Connection con = Conexion.Conexion.getConexion();
            //Consulta
            PreparedStatement pst = con.prepareCall("select * from cliente where id=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setMembresia(rs.getDouble("membresia"));
            }
        } catch (Exception e) {
             System.out.println("Error al buscar cliente " + e.getMessage());
        }
        return cliente;
    };

    @Override
    public boolean AgregarCliente(Cliente cliente) {
       boolean agregado = false;
        try {
            Connection con = Conexion.Conexion.getConexion();
            //Consulta
            String sql = "INSERT INTO cliente(id, nombres, apellidos, membresia) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getId());
            pst.setString(2, cliente.getNombres());
            pst.setString(3,cliente.getApellidos());
            pst.setInt(4, (int)cliente.getMembresia());
           int filasafectadas = pst.executeUpdate();
           agregado = filasafectadas>0;
        } catch (Exception e) {
            System.out.println("Error al agregar cliente " + e.getMessage());
        }
        return agregado;
    }

    @Override
    public boolean ModificarCliente(Cliente cliente) {
        return false;
    }

    @Override
    public boolean EliminarCliente(int id) {
        boolean eliminado = false;
        try {
            Connection con = Conexion.Conexion.getConexion();
            //Consulta 
            String sql = "delete from cliente where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            int eliminate = pst.executeUpdate();
            eliminado = eliminate>0;
        } catch (Exception e) {
        }
        return eliminado;
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
        
        //mostrar los datos
        //clientes.forEach(System.out::println);
        //IClienteDAO clienteDAO = new ClienteDAO();
        //var cliente = clienteDAO.BuscarClientesPorId(1);
        //System.out.println(cliente);
        
        //Agregar cliente
        IClienteDAO clienteDao = new  ClienteDAO();
        Cliente cliente = new Cliente(1,"Elvis","Cayllahua",35.5);
        System.out.println(clienteDao.AgregarCliente(cliente));
        
        //Eliminar cliente
         //ClienteDAO clienteDao = new ClienteDAO();
        //var cliente = clienteDao.EliminarCliente(1);
        //System.out.println(cliente);
    }
}
