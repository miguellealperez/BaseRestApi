package co.vinni.funcional.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.vinni.funcional.modelo.Propietario;

@Repository
public interface PropietarioRepositorio extends JpaRepository<Propietario, Long> {
    
}
