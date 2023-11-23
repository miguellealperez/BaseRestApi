package co.vinni.funcional.modelo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeguroToRiesgo implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIO_SEQ")
    @SequenceGenerator(sequenceName = "sq_SEGTORIESGO", allocationSize = 1, name = "FUNCIO_SEQ")
    private long id;

    private long valor;
    private String descripcion;
    private Date vigencia;
    private boolean vigente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo_id", nullable = true)
    @JsonIgnore
    private Vehiculo vehiculo;

}
