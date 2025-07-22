package zegel.Evaluacion2.servicio;

import zegel.Evaluacion2.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List<Empleado> ListarEmpleados();
    public Empleado BuscarEmpleadoPorID(int idEmpleado);
    public void GuardarEmpleado(Empleado empleado);
    public void EliminarEmpleadoPorID(int idEmpleado);
}
