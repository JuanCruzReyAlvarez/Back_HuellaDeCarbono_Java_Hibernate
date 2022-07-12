package dds.tp.carbono.entities.organization;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.entities.organization.notifications.Contacts;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaOrganizacion;
import dds.tp.carbono.validators.organizacion.OrganizacionValidator;
import lombok.Getter;
import lombok.Setter;

public class Organizacion {
    @Getter @Setter private Integer id;
    @Getter @Setter private String razonSocial;
    @Getter @Setter private Clasificacion clasificacion;
    @Getter @Setter private TipoOrganizacion tipo;
    @Getter @Setter private PuntoGeografico ubicacion;
    @Getter @Setter private Set<Sector> sectores;
    @Getter @Setter private Usuario user;

    private List<MetricaOrganizacion> metricas;

    private List<Contacts> contactos;

    public Organizacion() {
        this.sectores = new HashSet<Sector>();
        this.metricas = new ArrayList<MetricaOrganizacion>();
        this.contactos = new ArrayList<Contacts>();
    }

    public boolean isValid() {
        return new OrganizacionValidator().validate(this);
    }
    
    public HuellaCarbono calcularHC(PeriodoDeImputacion periodo) throws Exception {
        CalculadorHuellaOrganizacion calculador = new CalculadorHuellaOrganizacion(this, periodo); 
        return calculador.calcula();
    }

    public List<MetricaOrganizacion> getMetricas(PeriodoDeImputacion periodo) {
        return this.metricas.stream()
            .filter(m -> m.getPeriodoDeImputacion().equals(periodo))
            .collect(Collectors.toList());
    }

    public void addMetricas(List<MetricaOrganizacion> metricas) {
        this.metricas.addAll(metricas);
    }

    public void addContacto(Contacts contacto) {
        this.contactos.add(contacto);
    }
}
