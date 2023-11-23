package co.vinni.funcional.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import co.vinni.funcional.modelo.Propietario;
import co.vinni.funcional.repositorio.PropietarioRepositorio;

@Service
public class PropietarioServicio {
    private final PropietarioRepositorio propietarioRepositorio;

    public PropietarioServicio(PropietarioRepositorio propietarioRepositorio) {
        this.propietarioRepositorio = propietarioRepositorio;
    }

    public List<Propietario> findAll() {
        return propietarioRepositorio.findAll();
    }

    public Propietario findById(Long id) {
        return propietarioRepositorio.findById(id).orElseThrow();
    }
}
