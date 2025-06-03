package zegel.zona_fit.servicio;

import zegel.zona_fit.modelo.Cliente;

import java.util.List;

public class ClienteServicio implements IClienteServicio {

    @Override
    public List<Cliente> listarClientes() {
        return List.of();
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) {
        return null;
    }

    @Override
    public void guardarCliente(Cliente cliente) {

    }

    @Override
    public void eliminarCliente(Cliente cliente) {

    }
}
