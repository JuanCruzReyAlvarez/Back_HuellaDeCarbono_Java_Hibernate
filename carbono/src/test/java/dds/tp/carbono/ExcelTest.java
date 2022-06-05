package dds.tp.carbono;

import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.reader.ExcelImporter;
import dds.tp.carbono.services.org.metrics.converter.MetricasDeOrganizacionConverter;
import dds.tp.carbono.services.org.metrics.metrics.Actividad;
import dds.tp.carbono.services.org.metrics.metrics.Consumo;
import dds.tp.carbono.services.org.metrics.metrics.MetricasDeOrganizacion;
import dds.tp.carbono.services.org.metrics.metrics.Periodicidad;
import dds.tp.carbono.services.org.metrics.metrics.TipoDeConsumo;
import dds.tp.carbono.services.org.metrics.metrics.Unidad;


public class ExcelTest {

    @Test
    public void metricasConverterTest() {

        try(InputStream is = this.getClass().getClassLoader().getResourceAsStream("sample2.xlsx")){
            
            ExcelImporter importer = new ExcelImporter();
            
            List<ImportableModel> excelData = importer.importFrom(is, ImportableModel.class);

            MetricasDeOrganizacionConverter converter = new MetricasDeOrganizacionConverter();

            List<MetricasDeOrganizacion> listaDeMetricas = converter.convertir(excelData);

            Assert.assertEquals(Actividad.CombustionFija, listaDeMetricas.get(0).getActividad());
            Assert.assertEquals(TipoDeConsumo.GNC, listaDeMetricas.get(5).getTipoDeConsumo());
            Assert.assertEquals(Double.valueOf(1000), listaDeMetricas.get(0).getConsumo().getValor());
            Assert.assertEquals(Periodicidad.ANUAL, listaDeMetricas.get(0).getConsumo().getPeriodicidad());
            Assert.assertEquals(Unidad.LT, listaDeMetricas.get(0).getConsumo().getUnidad());
            Assert.assertEquals(11, listaDeMetricas.get(1).getPeriodoDeImputacion().getFechaInicio().getMonthValue());
            Assert.assertEquals(2021, listaDeMetricas.get(1).getPeriodoDeImputacion().getFechaInicio().getYear());
            Assert.assertEquals(1, listaDeMetricas.get(7).getPeriodoDeImputacion().getFechaInicio().getMonthValue());
            Assert.assertEquals(2022, listaDeMetricas.get(7).getPeriodoDeImputacion().getFechaInicio().getYear()); 
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
