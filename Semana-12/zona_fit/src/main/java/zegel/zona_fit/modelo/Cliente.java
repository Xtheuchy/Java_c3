package zegel.zona_fit.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Anotaciones de Lombok
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //El Id se autogenere
    private     Integer id;
    private     String nombres;
    private     String apellidos;
    private     double membresia;
}
