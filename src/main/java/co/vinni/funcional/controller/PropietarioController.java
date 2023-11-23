package co.vinni.funcional.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.vinni.funcional.modelo.Propietario;
import co.vinni.funcional.servicios.PropietarioServicio;

@RestController
@RequestMapping("/propietario")
public class PropietarioController {
    
    private final PropietarioServicio propietarioServicio;

    public PropietarioController(PropietarioServicio propietarioServicio) {
        this.propietarioServicio = propietarioServicio;
    }

    @GetMapping
    public List<Propietario> getPropietarios() {
        return propietarioServicio.findAll();
    }

    @GetMapping("/{id}")
    public Propietario getPropietarioById(Long id) {
        return propietarioServicio.findById(id);
    }
}
