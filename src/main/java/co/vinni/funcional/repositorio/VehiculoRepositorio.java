package co.vinni.funcional.repositorio;

import co.vinni.funcional.modelo.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VehiculoRepositorio extends JpaRepository<Vehiculo, Long> {

}
