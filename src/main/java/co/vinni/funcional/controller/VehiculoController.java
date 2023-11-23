package co.vinni.funcional.controller;

import co.vinni.funcional.modelo.Vehiculo;
import co.vinni.funcional.servicios.VehiculoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// @RequiredArgsConstructor
@RequestMapping("/vehiculo")
public class VehiculoController {
    // @Autowired
    private final VehiculoServicio vehiculoServicio;
    
    public VehiculoController(VehiculoServicio vehiculoServicio) {
        this.vehiculoServicio = vehiculoServicio;
    }
    @GetMapping
    public ResponseEntity<List<Vehiculo>> getVehiculos() {
        var getAllVehiculos = vehiculoServicio.findAll();
        return new ResponseEntity<>(getAllVehiculos, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable Long id) {
        var getVehiculoById = vehiculoServicio.findById(id);
        return new ResponseEntity<>(getVehiculoById, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Vehiculo> createVehiculo(@RequestBody Vehiculo vehiculo) {
        var createVehiculo = vehiculoServicio.save(vehiculo);
        return new ResponseEntity<>(createVehiculo, HttpStatus.CREATED);
    }
    

}
