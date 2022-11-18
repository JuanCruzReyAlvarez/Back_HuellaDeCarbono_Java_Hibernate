package dds.tp.carbono.services.reportes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reporte_miembro")
public class ReportMiembro {
    
    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Column(name="fecha")
    @Getter @Setter private LocalDate fechaGeneracion;
    
    @Column(name="huella")
    @Getter @Setter private Double huellaCarbono;

    @Column(name="id_Miembro")
    @Getter @Setter private Integer idMiembro;

}
