package Controlador;
//1.- Importar librerias
import java.sql.*; //-->Trabajar con la BD
import java.util.ArrayList; //--> tabla en memoria
import javax.swing.JOptionPane; //--> Cuadros de dialogo
//Mis librerias
import Modelo.Cliente;
import Conexion.ConexionBD;
public class ClienteController {
    //2. crear objetos(variables) generales(Globales)
    Connection cn = ConexionBD.getConexion();
    PreparedStatement pst = null;
    ResultSet rs = null;  
    
    //3. Implentar programas: Listar clientes, Insertar clientes, etc.
    //A.- Treer todos los clientes
    public ArrayList<Cliente> ListarClientes(){
        //a. crear un arrayList local
        ArrayList Lista = new ArrayList();
        //b. crear objeto de la clase
        Cliente cliente;
        try { //Se evalua el codigo
            String sql = "select * from cliente";
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) { //Verifica si hay datos en RS  
                cliente= new  Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setMembresia(rs.getDouble("membresia"));
                //Agregar a la lista
                Lista.add(cliente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return Lista;
    }
    //B.- Insertar cliente
    public void InsertarCliente(Cliente C){
        try {
            String sql = "Insert into cliente values(null,?,?,?)";
            pst = cn.prepareStatement(sql);
            //Agregar parametros en la instruccion
            pst.setString(1, C.getNombres());
            pst.setString(2,C.getApellidos());
            pst.setDouble(3, C.getMembresia());
            //Ejecutar instruccion en la BD
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente Agregado"+ C);
            cn.close();
        } catch (Exception e) { //Indica el error
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void EliminarCliente(Cliente C){
        try {
            String sql = "delete from cliente where id=?";
            pst = cn.prepareStatement(sql);
            pst.setInt(1, C.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente con id : " + C.getId() + " Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void ActualizarCliente(Cliente C){
        try {
            String sql = "update cliente set nombres=?, apellidos=?, membresia=? where id=?";
            pst = cn.prepareStatement(sql);
            pst.setString(1,C.getNombres());
            pst.setString(2,C.getApellidos());
            pst.setDouble(3, C.getMembresia());
            pst.setInt(4, C.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente Actualizado"+ C);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void BuscarCliente(Cliente C){
        try {
            String sql = "select * from cliente where id = ?";
            pst = cn.prepareStatement(sql);
            pst.setInt(1, C.getId());
            rs = pst.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setMembresia(rs.getDouble("membresia"));
                JOptionPane.showMessageDialog(null, "Cliente encontrado : "+cliente);
            } 
        } catch (Exception e) {
        }
    }
}
