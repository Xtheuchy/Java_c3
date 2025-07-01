package zegel.zona_fit.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zegel.zona_fit.modelo.Cliente;
import zegel.zona_fit.servicio.IClienteServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//1.- Indicar a spring que este formulario será parte de spring
@Component
//2.- Heredar las caracteristicas del JFrame
public class frmZonaFit extends JFrame{
    private JPanel panelPrincipal;
    private JTable clienteTabla;
    private JScrollPane scrollPane1;
    private JTextField nombreTexto;
    private JTextField ApellidoTexto;
    private JTextField MembresiaTexto;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JButton eliminarButton;
    //Crear un modelo de tabla
    private DefaultTableModel tablaModeloCliente;

    //3.- Inyectar dependencia
    //3.1-Definir un atributo
    IClienteServicio clienteServicio;
    //3.2-Crear el constructor
    @Autowired
    public frmZonaFit(IClienteServicio clienteServicio){
        //3.3 Inicializar al atributo
        this.clienteServicio = clienteServicio;
        //Llamar al programa de configuración inicial
        IniciarFormulario();
        guardarButton.addActionListener(new ActionListener() {
            @Override //Cuando el usuario presione click en guardar
            public void actionPerformed(ActionEvent e) {
                //Llamar al programa que guarda al cliente
                guardarCliente();
                ListarCliente();
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminar();
                ListarCliente();
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
    }
    //4-Configuración inicial al formulario (Caracteristicas)
    private void IniciarFormulario() {
        setContentPane(panelPrincipal); //Contenedor principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar la aplicacion
        setSize(800,600);//Ancho y alto de la ventana
        setLocationRelativeTo(null); //Centra el contenido
    }
    //Este metodo es para crear o agregar caracteristicas al Jtable
    private void createUIComponents() {
        // a. Establecer cabeceras a JTable
        this.tablaModeloCliente = new DefaultTableModel(0, 4); // 0 filas, 4 columnas
        String[] cabeceras = {"ID", "Nombres", "Apellidos", "Membresía"};

        // Establecer las cabeceras al modelo
        this.tablaModeloCliente.setColumnIdentifiers(cabeceras);

        // Crear la tabla con el modelo
        this.clienteTabla = new JTable(tablaModeloCliente);
        //Llamar al programa que liste clientes
        ListarCliente();
    }
    //1. Crear un programa que liste todos los clientes
    private void ListarCliente(){
        this.tablaModeloCliente.setRowCount(0);
        //Ya tenemos todos los datos de los clientes
        var clientes = this.clienteServicio.listarClientes();
        //Recorrer a cada cliente
        clientes.forEach(cliente -> {
            //Crear un array de tipo objet
            Object[] regloncliente = {
                    cliente.getId(),
                    cliente.getNombres(),
                    cliente.getApellidos(),
                    cliente.getMembresia()
            };
            this.tablaModeloCliente.addRow(regloncliente);
        });
    }
    //2. Guardad un cliente
    public void guardarCliente(){
        Cliente cliente = new Cliente();
        String nombre = this.nombreTexto.getText();
        String apellido = this.ApellidoTexto.getText();
        double membreria = Double.parseDouble(this.MembresiaTexto.getText());
        cliente.setNombres(nombre);
        cliente.setApellidos(apellido);
        cliente.setMembresia(membreria);
        clienteServicio.guardarCliente(cliente);
        JOptionPane.showMessageDialog(null, "Cliente agregado exitosamente");
    }
    public void eliminar(){
         int columnaId = this.clienteTabla.getColumnModel().getColumnIndex("ID");
         var select = this.clienteTabla.getSelectedRow();
         Object cliente = this.clienteTabla.getValueAt(select,columnaId);
         Cliente cliente1 = clienteServicio.buscarClientePorId((int) cliente);
         clienteServicio.eliminarCliente(cliente1);
         JOptionPane.showMessageDialog(null,"Cliente eliminado");
    }
    public void limpiar(){
        this.nombreTexto.setText("");
        this.ApellidoTexto.setText("");
        this.MembresiaTexto.setText("");
    }
}
