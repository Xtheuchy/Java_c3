package zegel.zona_fit.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import zegel.zona_fit.modelo.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente,Integer> {

}
