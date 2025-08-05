package zegel.Evaluacion2.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Agregamos las anotaciones de lombok
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Hacemos que el ID de Auto Genere
    Integer idEmpleado;
    String Nombre;
    String Correo;
    String Departamento;
}
