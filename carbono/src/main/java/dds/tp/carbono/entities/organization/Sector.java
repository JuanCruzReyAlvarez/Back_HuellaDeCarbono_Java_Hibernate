package dds.tp.carbono.entities.organization;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class Sector {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    @Getter @Setter private Organizacion organizacion;
    @Getter @Setter private Set<SolicitudVinculacion> solicitudes;
}
