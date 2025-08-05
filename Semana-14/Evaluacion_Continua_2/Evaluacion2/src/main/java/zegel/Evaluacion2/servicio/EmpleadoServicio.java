package zegel.Evaluacion2.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zegel.Evaluacion2.modelo.Empleado;
import zegel.Evaluacion2.repositorio.IEmpleadoRepositorio;

import java.util.List;
@Service
public class EmpleadoServicio implements IEmpleadoServicio {
    //Inyectamos las dependencias
    @Autowired
    private IEmpleadoRepositorio empleadoRepositorio;
    @Override
    public List<Empleado> ListarEmpleados() {
        //Buscamos todos los empleados de la base de datos y lo guardamos en una lista
        List<Empleado> Empleados = empleadoRepositorio.findAll();
        //Retornamos la lista
        return Empleados;
    }
    @Override
    public Empleado BuscarEmpleadoPorID(int idEmpleado) {
        //Buscamos al empleado por su id, si no existe se retorna null
        Empleado empleado = empleadoRepositorio.findById(idEmpleado).orElse(null);
        return empleado;
    }
    @Override
    public void GuardarEmpleado(Empleado empleado) {
        //Guardamos un nuevo empleado en nuesta BD
        empleadoRepositorio.save(empleado);
    }

    @Override
    public void EliminarEmpleadoPorID(int idEmpleado) {
        //Eliminamos un empleado por su id
        empleadoRepositorio.deleteById(idEmpleado);
    }
}
