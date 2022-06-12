package dds.tp.carbono.services.organizacion.metrics;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;

public class MetricaOrganizacionConverter {


    public List<MetricaOrganizacion> convertir(List<ImportableModel> data) throws Exception {

        List<MetricaOrganizacion> list = new ArrayList<>();

        for (ImportableModel importable : data)
            list.add(this.convert(importable));
        
        return list;
   }

    private MetricaOrganizacion convert(ImportableModel importable) throws Exception {

        MetricaOrganizacionBuilder builder = new MetricaOrganizacionBuilder();

        return builder.addActividad(importable)
                      .addConsumo(importable)
                      .addPeriodoDeImputacion(importable)
                      .build();
    }
}
