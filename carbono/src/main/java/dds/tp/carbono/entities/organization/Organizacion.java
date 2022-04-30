package dds.tp.carbono.entities.organization;

import java.util.Set;

import dds.tp.carbono.entities.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;

public class Organizacion {
    @Getter @Setter private Integer id;
    @Getter @Setter private String razonSocial;
    @Getter @Setter private TipoOrganizacion tipo;
    @Getter @Setter private Clasificacion clasificacion;
    @Getter @Setter private PuntoGeografico ubicacion;
    @Getter @Setter private Set<Sector> sectores;
}
