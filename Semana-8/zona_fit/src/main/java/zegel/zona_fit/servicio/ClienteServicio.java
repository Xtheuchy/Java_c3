package zegel.zona_fit.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zegel.zona_fit.modelo.Cliente;
import zegel.zona_fit.repositorio.ClienteRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio implements IClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Override
    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) {
        Optional<Cliente> cliente = clienteRepositorio.findById(idCliente);
        return cliente.orElse(null);
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepositorio.delete(cliente);
    }
}
