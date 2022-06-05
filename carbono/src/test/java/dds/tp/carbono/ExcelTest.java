package dds.tp.carbono;

import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.reader.ExcelImporter;
import dds.tp.carbono.services.org.metrics.converter.MetricasDeOrganizacionConverter;
import dds.tp.carbono.services.org.metrics.metrics.Actividad;
import dds.tp.carbono.services.org.metrics.metrics.MetricasDeOrganizacion;


public class ExcelTest {

    @Test
    public void metricasConverterTest() {

        try(InputStream is = this.getClass().getClassLoader().getResourceAsStream("sample2.xlsx")){
            
            ExcelImporter importer = new ExcelImporter();
            
            List<ImportableModel> excelData = importer.importFrom(is, ImportableModel.class);

            MetricasDeOrganizacionConverter converter = new MetricasDeOrganizacionConverter();

            List<MetricasDeOrganizacion> listaDeMetricas = converter.convertir(excelData);

            Assert.assertEquals(Actividad.CombustionFija, listaDeMetricas.get(0).getActividad());
            
            
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        











    }
    
}
