package zegel.zona_fit.servicio;

import zegel.zona_fit.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {
    //Describir las acciones de la clase Cliente
    //No esta la implementación
    public List<Cliente> listarClientes();
    public Cliente buscarClientePorId(Integer idCliente);
    public void guardarCliente(Cliente cliente);
    public void eliminarCliente(Cliente cliente);
}
