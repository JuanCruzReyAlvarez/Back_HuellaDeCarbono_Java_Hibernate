package dds.tp.carbono.services.organizacion.metrics.converter;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.services.organizacion.metrics.builder.MetricaOrganizacionBuilder;

public class MetricaOrganizacionConverter {

    public List<MetricaOrganizacion> convertir(List<ImportableModel> data) throws Exception {
        
        List<MetricaOrganizacion> metricas = new ArrayList<>();
        System.out.println(data.size());

        for (int i = 0; i < data.size(); i++){
            System.out.println("PASO "+ i);
            System.out.println(data.get(i).getActividad());
            System.out.println(data.get(i).isActividadLogistica());
            //System.out.println("paso6");
            //System.out.println(data.get(i).getActividad());
            //System.out.println(data.get(i).isActividadLogistica());
            //System.out.println("paso7");
            if (data.get(i).isActividadLogistica()) {
                ImportableModel[] logistica = new ImportableModel[] {
                data.get(i), data.get(i + 1), data.get(i + 2), data.get(i + 3) };
                MetricaLogisticaConverter converter = new MetricaLogisticaConverter(logistica);
                metricas.add(converter.convert());
                System.out.println(metricas.size());
                i += 3;
            } else{
                    System.out.println("No es logistica");
                    System.out.println(data.get(i).getActividad());
                    System.out.println(data.get(i).getPeriodicidad());
                    System.out.println(data.get(i).getPeriodoDeImputacion());
                    System.out.println(data.get(i).getTipoDeConsumo());
                    System.out.println(data.get(i).getValor());
                    System.out.println(convert(data.get(i)).getActividad());


                    metricas.add(convert(data.get(i)));

                    System.out.println("q onda");
                    //System.out.println(convert(data.get(i)).getActividad().getTipoActividad());
                    }
            }

        return metricas;
   }

    private MetricaOrganizacion convert(ImportableModel importable) throws Exception {

        MetricaOrganizacionBuilder builder = new MetricaOrganizacionBuilder();

        return builder.addActividad(importable)
                      .addPeriodoDeImputacion(importable)
                      .build();
    }
}