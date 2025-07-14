package zegel.inventario.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zegel.inventario.modelo.Producto;
import zegel.inventario.repositorio.ProductoRepositorio;
import java.util.List;
//Implementar las acciones internas
@Service
public class ProductoServicio implements IProductoServicio{
    //Inyeccion de Dependencia "repositorio"
    //Tiene las acciones del CRUD
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Override
    public List<Producto> listarProductos() {
        List<Producto> productos = this.productoRepositorio.findAll();
        return productos;
    }
    @Override
    public Producto buscarProducto(Integer idProducto) {
        Producto producto = this.productoRepositorio.findById(idProducto).orElse(null);
        return producto;
    }
    @Override
    public void guardadProducto(Producto producto) {
        this.productoRepositorio.save(producto);
    }
    @Override
    public void eliminarProductoId(Integer idProducto) {
        this.productoRepositorio.deleteById(idProducto);
    }
}
