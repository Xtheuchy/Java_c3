package zegel.inventario.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Crear la tabla en la DB
@Data   //Genere los GETTER Y SETTER
@NoArgsConstructor //Constructor sin argumentos
@AllArgsConstructor //Constructor con todos los argumentos
public class Producto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idProducto;
    String descripcion;
    double precio;
    Integer Existencias;
}
