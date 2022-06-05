package dds.tp.carbono.services.org.metrics.converter;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.services.org.metrics.metrics.MetricasDeOrganizacion;
import dds.tp.carbono.services.org.metrics.metrics.MetricasDeOrganizacionBuilder;

public class MetricasDeOrganizacionConverter {


    public List<MetricasDeOrganizacion> convertir(List<ImportableModel> data) throws Exception {

        List<MetricasDeOrganizacion> list = new ArrayList<>();

        for (ImportableModel importable : data)
            list.add(this.convert(importable));
        
        return list;
   }

    private MetricasDeOrganizacion convert(ImportableModel importable) throws Exception {

        MetricasDeOrganizacionBuilder builder = new MetricasDeOrganizacionBuilder();

        return builder.addActividad(importable)
                      .addConsumo(importable)
                      .addPeriodoDeImputacion(importable)
                      .build();
    }
}
