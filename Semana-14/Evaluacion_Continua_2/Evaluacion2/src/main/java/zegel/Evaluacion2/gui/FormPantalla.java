package zegel.Evaluacion2.gui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zegel.Evaluacion2.modelo.Empleado;
import zegel.Evaluacion2.servicio.EmpleadoServicio;
import zegel.Evaluacion2.servicio.IEmpleadoServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Indicamos que este formulario sera parte de spring
@Component
public class FormPantalla extends JFrame { //Hereda caracteristicas de JFrame
    private JPanel PanelPrincipal;
    private JTable TablaEmpleados;
    private JTextField NombreTXT;
    private JTextField DepartamentoTXT;
    private JTextField CorreoTXT;
    private JButton GuardarBTN;
    private JButton EliminarBTN;
    private JButton LimpiarBTN;
    //Crear un modelo de tabla
    private DefaultTableModel TablaModeloEmpleado;
    //Id sin datos
    private Integer idEmpleado;

    //Inyectar dependencias
    IEmpleadoServicio empleadoServicio;
    //Crear el constructor
    @Autowired
    public FormPantalla(IEmpleadoServicio empleadoServicio){
        //Inicializar atributo
        this.empleadoServicio = empleadoServicio;
        //Configuracion inicial
        InicializarPantalla();
        TablaEmpleados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //Cuando el usuario presiona un Clic en un registro
                //del JTable
                // Obtenemos el # de fila de la selección
                var reglon = TablaEmpleados.getSelectedRow();
                //Validamos la seleccion
                if (reglon!=-1){
                    //Obtenemos los datos
                    //Obtenemos el id y lo convertimos en INTEGER
                    idEmpleado = Integer.parseInt(TablaEmpleados.getValueAt(reglon,0).toString());
                    var Empleado = empleadoServicio.BuscarEmpleadoPorID(idEmpleado);
                    //Rellenamos los campos de texto con los datos el Empleado
                    NombreTXT.setText(Empleado.getNombre());
                    CorreoTXT.setText(Empleado.getCorreo());
                    DepartamentoTXT.setText(Empleado.getDepartamento());
                }
            }
        });
        GuardarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEmpleado();
            }
        });
        EliminarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarEmpleado();
            }
        });
        LimpiarBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
    }
    //Funcion para limpiar los campos
    private void limpiar() {
        this.NombreTXT.setText("");
        this.CorreoTXT.setText("");
        this.DepartamentoTXT.setText("");
        //Establecer en null el idEmpleado
        this.idEmpleado = null;
        //Quitar la seleccion en La tabla Empleados
        this.TablaEmpleados.getSelectionModel().clearSelection();
    }
    //Funcion para eliminar empleado
    private void eliminarEmpleado() {
        if (this.idEmpleado == null){
            JOptionPane.showMessageDialog(null,"Seleccione un empleado!!");
        }else{
            empleadoServicio.EliminarEmpleadoPorID(this.idEmpleado);
            listarEmpleados();
            limpiar();
            JOptionPane.showMessageDialog(null,"Empleado eliminado correctamente");
        }
    }
    //Funcion para Agregar, actualizar empledos
    private void guardarEmpleado() {
        //Validamos las cajas
        if (this.NombreTXT.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Ingrese su nombre!!");
        } else if (this.CorreoTXT.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese su correo");
        }else if (this.DepartamentoTXT.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese su Departamento");
        }else {
            String Nombre = this.NombreTXT.getText();
            String Correo = this.CorreoTXT.getText();
            String Departamento = this.DepartamentoTXT.getText();
            var Empleado = new Empleado(idEmpleado,Nombre,Correo,Departamento);
            //Guardamos el objeto Empleado
            empleadoServicio.GuardarEmpleado(Empleado);
            //Mostramos un mesaje de actualizacion o si es un cliente nuevo
            if (idEmpleado!=null){
                listarEmpleados();
                limpiar();
                JOptionPane.showMessageDialog(null,"Empleado actualizado correctamente!!");
            }else{
                listarEmpleados();
                limpiar();
                JOptionPane.showMessageDialog(null, "Guardado, Empleado nuevo!!");
            }
        }
    }
    //Configuraciones de pantalla
    private void InicializarPantalla() {
        setContentPane(PanelPrincipal);
        setTitle("SoftTech Solutions");
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Agregamos caracteristicas al JTable
    private void createUIComponents() {
        //a. Establecer Cabeceras al JTable
        this.TablaModeloEmpleado = new DefaultTableModel(0,4); //0 filas X 4 columnas
        String[] cabeceras = {"ID","Nombre","Correo","Departamento"};
        //b. Establecer cabecera al modelo
        this.TablaModeloEmpleado.setColumnIdentifiers(cabeceras);
        this.TablaEmpleados = new JTable(TablaModeloEmpleado);
        //Listar Empleados
        listarEmpleados();
    }
    //Creamos una funcion que liste todos los empleados
    private void listarEmpleados() {
        this.TablaModeloEmpleado.setRowCount(0);
        //Obtener todos los datos del Empleado
        var empleados = empleadoServicio.ListarEmpleados();
        //Recorrer a cada empleado
        empleados.forEach(empleado -> {
            Object[] reglonEmpleado = {
                    empleado.getIdEmpleado(),
                    empleado.getNombre(),
                    empleado.getCorreo(),
                    empleado.getDepartamento()
            };
            //Agregamos los datos a la tabla
            this.TablaModeloEmpleado.addRow(reglonEmpleado);
        });
    }
}
