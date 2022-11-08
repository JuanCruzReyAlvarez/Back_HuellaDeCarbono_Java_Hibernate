package dds.tp.carbono.entities.organization;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import dds.tp.carbono.entities.member.Miembro;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "solicitud_Vinculacion")

public class SolicitudVinculacion {
    
    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @ManyToOne
    @JoinColumn (name = "miembro_id", referencedColumnName = "id")
    @Getter @Setter private Miembro miembro;

    @ManyToOne
    @JoinColumn(name = "sector_id", referencedColumnName = "id")
    @Getter @Setter public Sector sector;

    @Enumerated(EnumType.STRING)
    @Getter @Setter private EstadoSolicitudVinculacion estado;
    
    public SolicitudVinculacion() {
        
    }

    public SolicitudVinculacion(Miembro miembro, Sector sector) {
        this.miembro = miembro;
        this.sector = sector;
        this.estado = EstadoSolicitudVinculacion.PENDIENTE;
    }
}
