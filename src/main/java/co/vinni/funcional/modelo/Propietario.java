package co.vinni.funcional.modelo;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Propietario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIO_SEQ")
    @SequenceGenerator(sequenceName = "sq_propietario", allocationSize = 1, name = "FUNCIO_SEQ")
    private long id;
    
    public Propietario(long id) {
        this.id = id;
    }

    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String direccion;

    @OneToMany(mappedBy = "propietario")
    private Set<Vehiculo> vehiculos;
    
    public void addVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        vehiculo.setPropietario(this);
    }

    public void removeVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
        vehiculo.setPropietario(null);
    }
}
