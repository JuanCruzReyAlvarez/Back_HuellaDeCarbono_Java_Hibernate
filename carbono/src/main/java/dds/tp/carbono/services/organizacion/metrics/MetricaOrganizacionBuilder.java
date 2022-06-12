package dds.tp.carbono.services.organizacion.metrics;

import dds.tp.carbono.entities.organization.metrics.Actividad;
import dds.tp.carbono.entities.organization.metrics.Consumo;
import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.entities.organization.metrics.Periodicidad;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.organization.metrics.Unidad;

public class MetricaOrganizacionBuilder {

    private MetricaOrganizacion metricas;

    public void MetricasDeOrganizacion() {
        this.metricas = new MetricaOrganizacion();
    }

    public MetricaOrganizacionBuilder addActividad(ImportableModel importable) throws Exception {

        Actividad actividad = Actividad.getBy(importable.getActividad());
        this.metricas.setActividad(actividad);

        return this;
    }

    public MetricaOrganizacionBuilder addConsumo(ImportableModel importable) throws Exception {
        Consumo consumo = new Consumo();

        this.addTipoDeConsumo(importable);
        consumo.setUnidad(Unidad.getBy(this.metricas.getTipoDeConsumo()));
        consumo.setValor(importable.getValor());
        Periodicidad periodicidad = Periodicidad.getBy(importable.getPeriodicidad());
        consumo.setPeriodicidad(periodicidad);
        this.metricas.setConsumo(consumo);

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

    private MetricaOrganizacionBuilder addTipoDeConsumo(ImportableModel importable) throws Exception {

        TipoDeConsumo tipo = TipoDeConsumo.getBy(importable.getTipoDeConsumo());
        this.metricas.setTipoDeConsumo(tipo);

        return this;
    }
}
