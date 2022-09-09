package dds.tp.carbono.entities.organization;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.huella.BuscadorMiembros;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.entities.organization.notifications.Contacts;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.validators.organizacion.OrganizacionValidator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "organizacion")
public class Organizacion {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Column(name="razonSocial")
    @Getter @Setter private String razonSocial;

    @ManyToOne
    @Getter @Setter private Clasificacion clasificacion;

    @Enumerated(EnumType.STRING)
    @Getter @Setter private TipoOrganizacion tipo;

    @OneToOne
    @Getter @Setter private PuntoGeografico ubicacion;

    @OneToMany(mappedBy = "organizacion",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @Getter @Setter private Set<Sector> sectores;

    @OneToOne
    @Getter @Setter private Usuario user;

    @Transient
    @Setter public BuscadorMiembros buscador;
    

    @OneToMany           
    private List<MetricaOrganizacion> metricas;

    @OneToMany
    private List<Contacts> contactos;

    public Organizacion() {
        this.sectores = new HashSet<Sector>();
        this.metricas = new ArrayList<MetricaOrganizacion>();
        this.contactos = new ArrayList<Contacts>();
    } 
    
    public boolean isValid() {
        return new OrganizacionValidator().validate(this);
    }
    

    public List<MetricaOrganizacion> getMetricas(PeriodoDeImputacion periodo) {
        return this.metricas.stream()
            .filter(m -> m.getPeriodoDeImputacion().equals(periodo))
            .collect(Collectors.toList());
    }

    public void addMetricas(List<MetricaOrganizacion> metricas) {
        this.metricas.addAll(metricas);
    }
    // nombre clases
    public void addContacto(Contacts contacto) {
        this.contactos.add(contacto);
    }

}


// el calculador tiene una organizacion laorganizacion solo e suna entidad