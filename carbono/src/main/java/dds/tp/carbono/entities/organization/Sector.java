package dds.tp.carbono.entities.organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import dds.tp.carbono.entities.member.Miembro;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sector")
public class Sector {
    
    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Column
    @Getter @Setter private String nombre;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    @Getter @Setter private Organizacion organizacion;

    @OneToMany(mappedBy = "sector", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @Getter @Setter private Set<SolicitudVinculacion> solicitudes;
    
    public Sector() {
     
    }
    
    public Sector(Integer id, String nombre, Organizacion organizacion, Set<SolicitudVinculacion> solicitudes) {
        this.id = id;
        this.nombre = nombre;
        this.organizacion = organizacion;
        this.solicitudes = solicitudes;
    }    

    public Sector(Integer id) {
        this.id = id;
    }
    public Sector(String nombre, String idOrg){
        this.nombre = nombre;
        this.organizacion = new Organizacion();
        this.organizacion.org();
        this.organizacion.setId(Integer.parseInt(idOrg)); 
    }

    public List<Miembro> getMiembros() {
        List<Miembro> miembros = new ArrayList<Miembro>() ;
        solicitudes.stream().
        filter(n->n.getEstado() == EstadoSolicitudVinculacion.ACEPTADO).
        collect(Collectors.toList()).forEach(a->miembros.add(a.getMiembro() ) );
        return miembros;
    }

}
