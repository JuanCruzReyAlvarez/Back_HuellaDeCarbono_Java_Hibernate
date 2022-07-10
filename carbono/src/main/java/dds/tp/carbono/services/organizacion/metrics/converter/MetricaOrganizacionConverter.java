package dds.tp.carbono.services.organizacion.metrics.converter;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.services.organizacion.metrics.builder.MetricaOrganizacionBuilder;

public class MetricaOrganizacionConverter {

    public List<MetricaOrganizacion> convertir(List<ImportableModel> data) throws Exception {
        
        List<MetricaOrganizacion> metricas = new ArrayList<>();

        for (int i = 0; i < data.size(); i++)
            if (data.get(i).isActividadLogistica()) {
                ImportableModel[] logistica = new ImportableModel[] { data.get(i), data.get(i + 1), data.get(i + 2), data.get(i + 3) };
                MetricaLogisticaConverter converter = new MetricaLogisticaConverter(logistica);
                metricas.add(converter.convert());
                i += 3;
            } else
                metricas.add(convert(data.get(i)));

        return metricas;
   }

    private MetricaOrganizacion convert(ImportableModel importable) throws Exception {

        MetricaOrganizacionBuilder builder = new MetricaOrganizacionBuilder();

        return builder.addActividad(importable)
                      .addPeriodoDeImputacion(importable)
                      .build();
    }
}