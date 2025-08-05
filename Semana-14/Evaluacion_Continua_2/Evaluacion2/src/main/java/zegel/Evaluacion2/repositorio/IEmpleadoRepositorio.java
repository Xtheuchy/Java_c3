package zegel.Evaluacion2.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import zegel.Evaluacion2.modelo.Empleado;

public interface IEmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
}
