/* 
package dds.tp.carbono.metricas;

import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.organization.metrics.Unidad;
import dds.tp.carbono.reader.ExcelImporter;
import dds.tp.carbono.services.organizacion.metrics.converter.MetricaOrganizacionConverter;

public class ExcelTest {

    @Test
    public void metricasConverterTest() {

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("sample2.xlsx")) {
            
            ExcelImporter importer = new ExcelImporter();
            
            List<ImportableModel> excelData = importer.importFrom(is, ImportableModel.class);

            MetricaOrganizacionConverter converter = new MetricaOrganizacionConverter();

            List<MetricaOrganizacion> listaDeMetricas = converter.convertir(excelData);

           
            Assert.assertEquals(TipoActividad.Combustion_Fija, listaDeMetricas.get(0).getActividad().getTipoActividad());
            Assert.assertEquals(TipoDeConsumo.Carbon, listaDeMetricas.get(5).getActividad().getTipoDeConsumo());
            Assert.assertEquals(Double.valueOf(1000), listaDeMetricas.get(0).getActividad().getDatoActividad().getValor());
            Assert.assertEquals(Unidad.LT, listaDeMetricas.get(0).getActividad().getDatoActividad().getUnidad());
            Assert.assertEquals(11, listaDeMetricas.get(1).getPeriodoDeImputacion().getFechaInicio().getMonthValue());
            Assert.assertEquals(2021, listaDeMetricas.get(1).getPeriodoDeImputacion().getFechaInicio().getYear());
            Assert.assertEquals(Double.valueOf(100000), listaDeMetricas.get(9).getActividad().getDatoActividad().getValor());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            Assert.assertFalse(true);
        }
    }  
}
*/