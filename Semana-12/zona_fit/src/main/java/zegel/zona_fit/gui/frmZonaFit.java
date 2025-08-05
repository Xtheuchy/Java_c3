package zegel.zona_fit.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zegel.zona_fit.modelo.Cliente;
import zegel.zona_fit.servicio.IClienteServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//1. Indicar a Spring que este formulario será parte de Spring
@Component  //2. Heredar Caracteristicas de JFrame
public class frmZonaFit extends JFrame {
    private JPanel panelPrincipal;
    private JTable clienteTabla;
    private JTextField nombreTexto;
    private JTextField apellidoTexto;
    private JTextField membresiaTexto;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JButton limpiarButton;
    //Crear un Modelo de Tabla
    private DefaultTableModel  tablaModeloCliente;
    private  Integer idCliente; //No tiene dato

    //3. Inyectar Dependencia
    //3.1. Definir un atributo
    IClienteServicio clienteServicio;

    //3.2. Crear el costructor
    @Autowired
    public  frmZonaFit(IClienteServicio  clienteServicio){
        //3.3. Inicializar al atributo
        this.clienteServicio = clienteServicio;
        //LLamar al programa de configuración inicial
        iniciarFormulario();
        guardarButton.addActionListener(new ActionListener() {
            @Override  //Cuando el usuario presione Click en Guardar
            public void actionPerformed(ActionEvent e) {
                //Llamar al programa que guarda al cliente
                guardarCliente();
            }
        });
        clienteTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //Cuando el usuario presiona un Clic en un registro
                //del JTable
                //1. Obtener el # de fila de la selección
                var reglon = clienteTabla.getSelectedRow();
                //JOptionPane.showMessageDialog(null,reglon);
                //2. Validar la selección
                if (reglon!=-1){ //Diferente:  0,1,2,3,4,5, ...
                    //Obtener los datos y establecer en las cajas
                    var id = clienteTabla.getModel().getValueAt(reglon,0).toString();
                    //Combertir a entero
                    idCliente = Integer.parseInt(id);
                    var nombre = clienteTabla.getModel().getValueAt(reglon,1).toString();
                    nombreTexto.setText(nombre);
                    var apellido = clienteTabla.getModel().getValueAt(reglon,2).toString();
                    apellidoTexto.setText(apellido);
                    var membresia = clienteTabla.getModel().getValueAt(reglon,3).toString();
                    membresiaTexto.setText(membresia);
                }
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Cuando el usuario presiona un Click en el botón Limpiar
                limpiarFormulario();
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Presiona Clic en Eliminar
                //Obtener el # de indice de la fila
                var reglon = clienteTabla.getSelectedRow();
                if (reglon!=1){ //Selecciono 0,1,2,3,4,5, ... Procede a eliminar
                   //Obtener el id del JTable
                    var idClienteStr = clienteTabla.getModel().getValueAt(reglon,0).toString();
                    idCliente = Integer.parseInt(idClienteStr); //Guardadndo el id en el atributo
                    //Crear un Objeto Cliente
                    var cliente = new Cliente(); //Objeto sin información
                    //Asignar su codigo al objeto
                    cliente.setId(idCliente);
                    //Ya tiene un estado ---> Eliminar al Cliente
                    clienteServicio.eliminarCliente(cliente);
                    JOptionPane.showMessageDialog(null,"Cliente Eliminado ok");
                    limpiarFormulario();
                    listarCliente();
                }
            }
        });
    }

    //4. Configuración inicial al formulario(caracteristicas)
    private  void   iniciarFormulario(){
        setContentPane(panelPrincipal); //Contenedor Principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar la App
        setSize(900,700); //Ancho y alto de la ventana
        setLocationRelativeTo(null); //Ubicación al centro
    }
    //Es para crear o agregar caracteristicas al JTable
    private void createUIComponents() {
        //a. Establecer Cabeceras al JTable
        this.tablaModeloCliente = new DefaultTableModel(0,4); //0 Filas  X  4 Columnas
        String[] cabeceras = {"Id","Nombres","Apellidos","Membresia"};
        //Establecer las cabeceras al Modelo
        this.tablaModeloCliente.setColumnIdentifiers(cabeceras);
        this.clienteTabla = new JTable(tablaModeloCliente);
        //Luego de las caracteristicas de la tabla
        //Llamar al programa que Liste todo los clientes
        listarCliente();
    }
    //1. Crear un Programa que Liste todos los Clientes
    private void listarCliente(){
        this.tablaModeloCliente.setRowCount(0);
        //Ya tenemos todo los datos de los clientes
        var clientes = this.clienteServicio.listarClientes();
        //Recorrer a cada cliente
        clientes.forEach(cliente -> {
            //Crear un array de tipo Object(int, String, ...)
            Object[] regloncliente = {
                    cliente.getId(),
                    cliente.getNombres(),
                    cliente.getApellidos(),
                    cliente.getMembresia()
            };
            //Es el momento de agregar a la tabla
            this.tablaModeloCliente.addRow(regloncliente);
        });
    }
    //2. Crear programa para guardar un cliente
    public void guardarCliente(){
        //1. Validar los campos(Cajas)
        if (nombreTexto.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese el Nombre");
            nombreTexto.requestFocusInWindow();//Ubicar el cursor
        }//Seria bueno que Uds. realizar validaciones
        //Guarde información Integra (Calidad)
        //2. Recuperar los datos de el formulario
            //3 campos(cajas de texto)
        var nombre  = nombreTexto.getText();
        var apellido = apellidoTexto.getText();
        var membresia = Double.parseDouble(membresiaTexto.getText());
        //3.Crear un Objeto a partir del Molde(Cliente)
        var cliente = new Cliente(this.idCliente,nombre,apellido,membresia); //Abjeto sin información
        //El objeto ya tiene estado(información)
        //4. Guardar en la Base de datos
        this.clienteServicio.guardarCliente(cliente);
        //5. Validación para Guardar al Cliente o Actualizar
        if (this.idCliente==null)
            JOptionPane.showMessageDialog(null,"Nuevo Cliente");
        else
            JOptionPane.showMessageDialog(null,"Cliente Actualizado");
        limpiarFormulario(); //Llamar antes de Listar
        listarCliente(); //Listando de nuevo
    }

    //Aplicación que Limpia las Cajas de texto
    private  void    limpiarFormulario(){
        nombreTexto.setText("");
        apellidoTexto.setText("");
        membresiaTexto.setText("");
        //Establecer en Null idCliente
        this.idCliente=null;
        //Quitar la seleccion del JTable
        this.clienteTabla.getSelectionModel().clearSelection();
    }
}
