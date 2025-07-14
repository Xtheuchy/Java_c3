package zegel.inventario.servicio;

import zegel.inventario.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    //Comportamiento de la clase "servicio"
    public List<Producto> listarProductos();
    public Producto buscarProducto(Integer idProducto);
    public void guardadProducto(Producto producto);
    public void eliminarProductoId(Integer idProducto);
}
