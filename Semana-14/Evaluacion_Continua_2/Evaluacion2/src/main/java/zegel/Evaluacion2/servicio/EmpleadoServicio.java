package zegel.Evaluacion2.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import zegel.Evaluacion2.modelo.Empleado;
import zegel.Evaluacion2.repositorio.IEmpleadoRepositorio;

import java.util.List;

public class EmpleadoServicio implements IEmpleadoServicio {
    @Autowired
    private IEmpleadoRepositorio empleadoRepositorio;
    @Override
    public List<Empleado> ListarEmpleados() {
        List<Empleado> Empleados = empleadoRepositorio.findAll();
        return Empleados;
    }

    @Override
    public Empleado BuscarEmpleadoPorID(int idEmpleado) {
        return null;
    }

    @Override
    public void GuardarEmpleado(Empleado empleado) {

    }

    @Override
    public void EliminarEmpleadoPorID(int idEmpleado) {

    }
}
