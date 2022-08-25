package dds.tp.carbono.entities.organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dds.tp.carbono.entities.member.Miembro;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sector")
public class Sector {
    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;
    @Column
    @Getter @Setter private String nombre;
    @ManyToOne
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    @Getter @Setter private Organizacion organizacion;
    @Transient
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
