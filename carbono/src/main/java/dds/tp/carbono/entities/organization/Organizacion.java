package dds.tp.carbono.entities.organization;

import java.util.HashSet;
import java.util.Set;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.point.Ubicable;
import lombok.Getter;
import lombok.Setter;

public class Organizacion implements Ubicable {
    @Getter @Setter private Integer id;
    @Getter @Setter private String razonSocial;
    @Getter @Setter private Clasificacion clasificacion;
    @Getter @Setter private TipoOrganizacion tipo;
    @Getter @Setter private PuntoGeografico ubicacion;
    @Getter @Setter private Set<Sector> sectores;

    public Organizacion() {
        this.sectores = new HashSet<Sector>();
    }	
}
