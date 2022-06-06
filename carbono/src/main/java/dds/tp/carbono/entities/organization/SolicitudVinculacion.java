package dds.tp.carbono.entities.organization;

import dds.tp.carbono.entities.member.Miembro;
import lombok.Getter;
import lombok.Setter;

public class SolicitudVinculacion {
    @Getter @Setter private Integer id;
    @Getter @Setter private Miembro miembro;
    @Getter @Setter private Sector sector;
    @Getter @Setter private EstadoSolicitudVinculacion estado;
    
    public SolicitudVinculacion(Miembro miembro, Sector sector) {
        this.miembro = miembro;
        this.sector = sector;
        this.estado = EstadoSolicitudVinculacion.PENDIENTE;
    }
}
