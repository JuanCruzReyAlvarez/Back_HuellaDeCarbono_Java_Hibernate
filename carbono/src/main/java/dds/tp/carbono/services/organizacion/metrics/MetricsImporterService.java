package dds.tp.carbono.services.organizacion.metrics;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.exception.InvalidFileException;
import dds.tp.carbono.reader.ExcelImporter;
import dds.tp.carbono.repository.organization.MetricaOrganizacionRepository;
import dds.tp.carbono.repository.organization.OrganizacionRepository;
import dds.tp.carbono.services.organizacion.metrics.converter.MetricaOrganizacionConverter;

// Es un service no pertenece a dominio no hay drama con el repository

public class MetricsImporterService {
    
    private Organizacion organizacion;
    private OrganizacionRepository repository;
    private MetricaOrganizacionRepository repositoryMetricas;
    private ExcelImporter importer;

    public MetricsImporterService(Organizacion org) {
        this.organizacion = org;
        this.repository = new OrganizacionRepository();
        this.importer = new ExcelImporter();
        this.repositoryMetricas = new MetricaOrganizacionRepository();
    }
    
    public List<MetricaOrganizacion> importExcel(InputStream excelInputStream) throws InvalidFileException, Exception {
        System.out.println("Paso1");
        List<ImportableModel> importables = new ArrayList<ImportableModel>();
        importables = this.importer.importFrom(excelInputStream, ImportableModel.class);
        System.out.println("Paso2");
        MetricaOrganizacionConverter converter = new MetricaOrganizacionConverter();
        System.out.println("Paso3");
        List<MetricaOrganizacion> metricas = new ArrayList<MetricaOrganizacion>();
        System.out.println("Paso4");
        System.out.println(importables.size());
        metricas = converter.convertir(importables);
        System.out.println("Paso10");
       
        this.repository.addMetrics(metricas, this.organizacion);

        System.out.println("PASO20");

        return metricas;
    }

    public void updateAll(List<MetricaOrganizacion> metricas, Integer id) {
        System.out.println("En save all");
        this.repositoryMetricas.updateAll( metricas, id);
    }


    //metood guardar metricas, llama al repository
}
