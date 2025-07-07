package zegel.zona_fit.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zegel.zona_fit.modelo.Cliente;
import zegel.zona_fit.repositorio.ClienteRepositorio;

import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio {
    //Inyectando dependencias
    @Autowired
    private ClienteRepositorio clienterepositorio;

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes  = clienterepositorio.findAll();
        return clientes;
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) {
        Cliente  cliente = clienterepositorio.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public void guardarCliente(Cliente cliente) {
            clienterepositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
            clienterepositorio.delete(cliente);
    }
}
