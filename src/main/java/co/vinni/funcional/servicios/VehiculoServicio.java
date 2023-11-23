package co.vinni.funcional.servicios;

import co.vinni.funcional.modelo.Vehiculo;
import co.vinni.funcional.repositorio.VehiculoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @RequiredArgsConstructor
@Service
public class VehiculoServicio {
    // @Autowired
    private final VehiculoRepositorio vehiculoRepositorio;

    
    public VehiculoServicio(VehiculoRepositorio vehiculoRepositorio) {
        this.vehiculoRepositorio = vehiculoRepositorio;
    }

    public Vehiculo findById(Long id) {
        return vehiculoRepositorio.findById(id).orElseThrow();
    }

    public List<Vehiculo> findAll() {
        return vehiculoRepositorio.findAll();
    }
    
    public Vehiculo save(Vehiculo vehiculo) {
        return vehiculoRepositorio.save(vehiculo);
    }
}
