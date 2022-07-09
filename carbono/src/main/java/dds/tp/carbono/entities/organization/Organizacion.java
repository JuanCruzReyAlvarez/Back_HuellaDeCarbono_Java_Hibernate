package dds.tp.carbono.entities.organization;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.services.huella.calculador.CalculadorHuellaCarbono;
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
    @Getter @Setter private List<MetricaOrganizacion> metricas;
    @Getter @Setter private Usuario user;

    public Organizacion() {
        this.sectores = new HashSet<Sector>();
        this.metricas = new ArrayList<MetricaOrganizacion>();
    }

    public boolean isValid() {
        return new OrganizacionValidator().validate(this);
    }
    
    public HuellaCarbono calcularHC(PeriodoDeImputacion periodo) throws Exception {
        CalculadorHuellaCarbono calculador = new CalculadorHuellaCarbono(this, periodo); 
        return calculador.calcula();
        } 
}
