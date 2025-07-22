package zegel.inventario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import zegel.inventario.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{

}
