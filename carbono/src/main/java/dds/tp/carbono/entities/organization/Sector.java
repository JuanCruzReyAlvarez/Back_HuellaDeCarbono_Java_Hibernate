package dds.tp.carbono.entities.organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import dds.tp.carbono.entities.member.Miembro;
import lombok.Getter;
import lombok.Setter;

public class Sector {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    @Getter @Setter private Organizacion organizacion;
    @Getter @Setter private Set<SolicitudVinculacion> solicitudes;
    
    public Sector(Integer id, String nombre, Organizacion organizacion, Set<SolicitudVinculacion> solicitudes) {
        this.id = id;
        this.nombre = nombre;
        this.organizacion = organizacion;
        this.solicitudes = solicitudes;
    }    

    public List<Miembro> getMiembros() {
        List<Miembro> miembros = new ArrayList<Miembro>() ;
        solicitudes.stream().
        filter(n->n.getEstado() == EstadoSolicitudVinculacion.ACEPTADO).
        collect(Collectors.toList()).forEach(a->miembros.add(a.getMiembro() ) );
        return miembros;
    }

}
