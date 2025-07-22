package zegel.inventario.controlador;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import zegel.inventario.modelo.Producto;
import zegel.inventario.servicio.ProductoServicio;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;
//1. Indicar que es un controlador de tipo REST
@RestController
//2. Establecer la ruta para exponer a la API
@RequestMapping("inventario-app")
//? http://localhost:8080/inventario-app
//3. Para que acepte peticiones desde Angular(Front End)
@CrossOrigin(value = "http://localhost:4200")
//Clase -->Exponer los datos por API
public class ProductoControlador {
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);
    //Inyectar la dependencia Producto Servicio
    @Autowired
    private ProductoServicio productoServicio;
    //Establecer una petición de tipo GET
    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos Obtenidos");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }
    @GetMapping("/buscar/{idproducto}")
    public Producto buscarProducto(@PathVariable Integer idproducto){
        Producto producto = productoServicio.buscarProducto(idproducto);
        logger.info(producto.toString());
        return producto;
    }
}
