package dds.tp.carbono.services.organizacion.metrics.builder;

import dds.tp.carbono.entities.organization.metrics.Actividad;
import dds.tp.carbono.entities.organization.metrics.Consumo;
import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.services.organizacion.metrics.factory.ActividadFactory;
import dds.tp.carbono.services.organizacion.metrics.factory.ConsumoFactory;

public class MetricaOrganizacionBuilder {

    private MetricaOrganizacion metricas;

    public MetricaOrganizacionBuilder() {
        this.metricas = new MetricaOrganizacion();
    }

    public MetricaOrganizacionBuilder addActividad(ImportableModel importable) throws Exception {
        Consumo consumo = ConsumoFactory.getConsumo(importable);
        TipoActividad tipoActividad = TipoActividad.getBy(importable.getActividad());
        Actividad actividad = ActividadFactory.crearActividad(tipoActividad, consumo);        
        this.metricas.setActividad(actividad);

        return this;
    }

    public MetricaOrganizacionBuilder addPeriodoDeImputacion(ImportableModel importable) throws Exception {
        PeriodoDeImputacion periodo = new PeriodoDeImputacion(importable.getPeriodoDeImputacion());
        this.metricas.setPeriodoDeImputacion(periodo);

        return this;
    }
    
    public MetricaOrganizacion build() throws Exception {
        if(this.metricas.isValid())
            return this.metricas;

        throw new Exception("No son válidas las metricas");
    }
}