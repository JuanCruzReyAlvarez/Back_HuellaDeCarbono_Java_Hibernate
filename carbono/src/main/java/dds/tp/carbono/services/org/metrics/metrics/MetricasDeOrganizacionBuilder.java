package dds.tp.carbono.services.org.metrics.metrics;

import dds.tp.carbono.entities.organization.metrics.ImportableModel;

// import dds.tp.carbono.services.org.metrics.converter.MetricasDeOrganizacionConverter;

// import dds.tp.carbono.entities.organization.metrics.ImportableModel;

public class MetricasDeOrganizacionBuilder {

    private MetricasDeOrganizacion metricas;

    public void MetricasDeOrganizacion() {
        this.metricas = new MetricasDeOrganizacion();
    }

    public MetricasDeOrganizacionBuilder addActividad(ImportableModel importable) throws Exception {

        Actividad actividad = Actividad.getBy(importable.getActividad());
        this.metricas.setActividad(actividad);

        return this;
    }


    public MetricasDeOrganizacionBuilder addConsumo(ImportableModel importable) throws Exception {
        Consumo consumo = new Consumo();

        this.addTipoDeConsumo(importable);
        consumo.setUnidad(Unidad.getBy(this.metricas.getTipoDeConsumo()));
        consumo.setValor(importable.getValor());
        Periodicidad periodicidad = Periodicidad.getBy(importable.getPeriodicidad());
        consumo.setPeriodicidad(periodicidad);
        this.metricas.setConsumo(consumo);

        return this;
    }

    public MetricasDeOrganizacionBuilder addPeriodoDeImputacion(ImportableModel importable) throws Exception{
        PeriodoDeImputacion periodo = new PeriodoDeImputacion(importable.getPeriodoDeImputacion());
        this.metricas.setPeriodoDeImputacion(periodo);

        return this;
    }
    
    public MetricasDeOrganizacion build() throws Exception{
        if(this.metricas.isValid())
            return this.metricas;

        throw new Exception("");
    }

    private MetricasDeOrganizacionBuilder addTipoDeConsumo(ImportableModel importable) throws Exception {

        TipoDeConsumo tipo = TipoDeConsumo.getBy(importable.getTipoDeConsumo());
        this.metricas.setTipoDeConsumo(tipo);

        return this;
    }

}
