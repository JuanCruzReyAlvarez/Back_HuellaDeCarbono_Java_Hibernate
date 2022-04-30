package dds.tp.carbono.entities.member;

import dds.tp.carbono.entities.PuntoGeografico;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.transport.Estacion;
import lombok.Getter;
import lombok.Setter;

public class PuntoTramo {
    @Getter @Setter private PuntoGeografico ubicacion;
    @Getter @Setter private Organizacion organizacion;
    @Getter @Setter private Estacion estacion;
    @Getter @Setter private String detalle;
}
