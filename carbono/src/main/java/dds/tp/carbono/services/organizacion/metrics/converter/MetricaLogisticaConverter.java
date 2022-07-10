package dds.tp.carbono.services.organizacion.metrics.converter;

import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.services.organizacion.metrics.builder.LogisticaDeProductosServiciosBuilder;

public class MetricaLogisticaConverter {
    
    private ImportableModel[] importables;
    private MetricaOrganizacion metrica;
    private LogisticaDeProductosServiciosBuilder builder;

    public MetricaLogisticaConverter(ImportableModel ...importables) {
        this.importables = importables;
        this.metrica = new MetricaOrganizacion();
        this.builder = new LogisticaDeProductosServiciosBuilder(this.importables);
    }

    public MetricaOrganizacion convert() throws Exception {
        this.validarCongruencia();
        this.addActividad();
        this.addPeriodoDeImputacion();
        
        return this.metrica;
    }

    private void validarCongruencia() throws Exception {
        for (ImportableModel importable : this.importables)
            if (!importable.isActividadLogistica())
                throw new Exception("Logistica wrong format");
    }

    private void addPeriodoDeImputacion() throws Exception {
        PeriodoDeImputacion periodo = new PeriodoDeImputacion(importables[0].getPeriodoDeImputacion());
        this.metrica.setPeriodoDeImputacion(periodo);
    }

    private void addActividad() throws Exception {
        this.metrica.setActividad(
            this.builder.addDistancia()
                        .addPeso()
                        .addCategoria()
                        .addTransporte()
                        .addTipoConsumo()
                        .build());                             
    }
}
