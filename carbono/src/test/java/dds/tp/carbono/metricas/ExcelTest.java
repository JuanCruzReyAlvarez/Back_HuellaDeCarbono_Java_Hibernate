package dds.tp.carbono.metricas;

import java.io.InputStream;

import org.junit.Test;

public class ExcelTest {

    @Test
    public void metricasConverterTest() {

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("sample2.xlsx")) {
            
            //ExcelImporter importer = new ExcelImporter();
            
            //List<ImportableModel> excelData = importer.importFrom(is, ImportableModel.class);

            // MetricaOrganizacionConverter converter = new MetricaOrganizacionConverter();

            // List<MetricaOrganizacion> listaDeMetricas = converter.convertir(excelData);

            // Assert.assertEquals(Actividad.CombustionFija, listaDeMetricas.get(0).getActividad());
            // Assert.assertEquals(TipoDeConsumo.GNC, listaDeMetricas.get(5).getTipoDeConsumo());
            // Assert.assertEquals(Double.valueOf(1000), listaDeMetricas.get(0).getConsumo().getValor());
            // Assert.assertEquals(Periodicidad.ANUAL, listaDeMetricas.get(0).getConsumo().getPeriodicidad());
            // Assert.assertEquals(Unidad.LT, listaDeMetricas.get(0).getConsumo().getUnidad());
            // Assert.assertEquals(11, listaDeMetricas.get(1).getPeriodoDeImputacion().getFechaInicio().getMonthValue());
            // Assert.assertEquals(2021, listaDeMetricas.get(1).getPeriodoDeImputacion().getFechaInicio().getYear());
            // Assert.assertEquals(1, listaDeMetricas.get(7).getPeriodoDeImputacion().getFechaInicio().getMonthValue());
            // Assert.assertEquals(2022, listaDeMetricas.get(7).getPeriodoDeImputacion().getFechaInicio().getYear()); 
            System.out.println("asd");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }  
}