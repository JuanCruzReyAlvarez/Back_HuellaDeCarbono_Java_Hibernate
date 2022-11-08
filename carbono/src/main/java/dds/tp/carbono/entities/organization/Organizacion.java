package dds.tp.carbono.entities.organization;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.huella.BuscadorMiembros;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.entities.organization.notifications.Contacts;
import dds.tp.carbono.entities.organization.notifications.MedioDeNotificacion;
import dds.tp.carbono.entities.organization.notifications.MensajeRecomendaciones;
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

    @Column(name="razon_Social")
    @Getter @Setter private String razonSocial;

    @Embedded
    @Getter @Setter private Clasificacion clasificacion;

    @Enumerated(value = EnumType.STRING)
    @Getter @Setter private TipoOrganizacion tipo;

    @OneToOne( fetch = FetchType.LAZY)
    @Getter @Setter private PuntoGeografico ubicacion;

    @OneToMany(mappedBy = "organizacion",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @Getter @Setter private Set<Sector> sectores;

    @OneToOne
    @Getter @Setter private Usuario user;

    @Transient
    @Getter @Setter public BuscadorMiembros buscador ;
    
    @OneToMany(mappedBy = "organizacion",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)           
    private List<MetricaOrganizacion> metricas;

    @OneToMany(mappedBy = "organizacion",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @Setter @Getter private List<Contacts> contactos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sectorTerritorial_id", referencedColumnName = "id")
    @Setter @Getter private SectorTerritorial sectorTerritorial;

    @Transient
    @Setter @Getter MedioDeNotificacion medioDeNotificacion;  

    public Organizacion() {}

    public void org() {
        
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

    public void agregarSector (Sector x) {
        this.sectores.add(x);
        x.setOrganizacion(this);
    }

    public void agregarMetricaOrganizacion (MetricaOrganizacion x) {
        this.metricas.add(x);
        x.setOrganizacion(this);
    }

    public void agregarContacto (Contacts x) {
        this.contactos.add(x);
        x.setOrganizacion(this);
    }

    public void enviarRecomendaciones(){

        MensajeRecomendaciones mensaje = new MensajeRecomendaciones();
        mensaje.setLink("agregarLINKrealAqui");

        for (Contacts contacto:this.getContactos()){
            this.medioDeNotificacion.enviarMensaje(mensaje, contacto);
        }
    }
        

}


