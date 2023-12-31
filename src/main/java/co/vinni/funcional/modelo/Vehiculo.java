package co.vinni.funcional.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIO_SEQ")
    @SequenceGenerator(sequenceName = "sq_vehiculos", allocationSize = 1, name = "FUNCIO_SEQ")
    private long id;

    private String placa;
    private int modelo;

    @OneToMany(mappedBy="vehiculo")
    private Set<Soat> soats;


    public void addSoat(Soat soat) {
        soats.add(soat);
        soat.setVehiculo (this);
    }

    public void removeSoat(Soat soat) {
        soats.remove(soat);
        soat.setVehiculo(null);
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "propietario_id", nullable = true)
    @JsonIgnore
    private Propietario propietario;

    @OneToMany(mappedBy = "vehiculo")
    private Set<SeguroToRiesgo> segurosToRiesgo;

    public void addSeguroToRiesgo(SeguroToRiesgo seguroToRiesgo) {
        segurosToRiesgo.add(seguroToRiesgo);
        seguroToRiesgo.setVehiculo(this);
    }

    public void removeSeguroToRiesgo(SeguroToRiesgo seguroToRiesgo) {
        segurosToRiesgo.remove(seguroToRiesgo);
        seguroToRiesgo.setVehiculo(null);
    }
}
