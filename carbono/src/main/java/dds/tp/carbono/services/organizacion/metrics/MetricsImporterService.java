package dds.tp.carbono.services.organizacion.metrics;

import java.io.InputStream;
import java.util.List;

import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.exception.InvalidFileException;
import dds.tp.carbono.reader.ExcelImporter;
import dds.tp.carbono.repository.organization.OrganizacionRepository;
import dds.tp.carbono.services.organizacion.metrics.converter.MetricaOrganizacionConverter;

public class MetricsImporterService {
    
    private Organizacion organizacion;
    private OrganizacionRepository repository;
    private ExcelImporter importer;

    public MetricsImporterService(Organizacion org) {
        this.organizacion = org;
        this.repository = new OrganizacionRepository();
        this.importer = new ExcelImporter();
    }
    
    public List<MetricaOrganizacion> importExcel(InputStream excelInputStream) throws InvalidFileException, Exception {
        List<ImportableModel> importables = this.importer.importFrom(excelInputStream, ImportableModel.class);

        MetricaOrganizacionConverter converter = new MetricaOrganizacionConverter();
        List<MetricaOrganizacion> metricas = converter.convertir(importables);
       
        this.repository.addMetrics(metricas, this.organizacion);

        return metricas;
    }
}
