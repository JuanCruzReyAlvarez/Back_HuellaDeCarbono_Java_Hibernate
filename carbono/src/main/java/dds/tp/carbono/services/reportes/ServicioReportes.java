package dds.tp.carbono.services.reportes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.http.dto.org.ReportDTO;
import dds.tp.carbono.repository.member.ReportMiembroRepository;
import dds.tp.carbono.repository.organization.ReportOrganizacionRepository;

public class ServicioReportes {
    
    private ReportMiembroRepository repositoryMiembro;
    private ReportOrganizacionRepository repositoryOrganizacion;


    public ServicioReportes() {
        this.repositoryMiembro = new ReportMiembroRepository();
        this.repositoryOrganizacion = new ReportOrganizacionRepository();
    }

    public void saveToReportOrganizacion(HuellaCarbono hc,Integer id){
        ReportOrganizacion reporte = new ReportOrganizacion();
        reporte.setFechaGeneracion(LocalDate.now());
        reporte.setHuellaCarbono(hc.getValor());
        reporte.setIdOrganizacion(id);
        repositoryOrganizacion.guardar(reporte);
    }

    public void saveToReportMiembro(HuellaCarbono hc,Integer id){
        ReportMiembro reporte = new ReportMiembro();
        reporte.setFechaGeneracion(LocalDate.now());
        reporte.setHuellaCarbono(hc.getValor());
        reporte.setIdMiembro(id);
        repositoryMiembro.guardar(reporte);
    }

    public ReportDTO getReportOrganizacion(Integer id,ReportDTO report ){
        Map<String, Double> map = new HashMap<String, Double>();
        List<ReportOrganizacion>reportesOrganizacion = new ArrayList<ReportOrganizacion>();
         ;
        reportesOrganizacion = repositoryOrganizacion.getAllReportesByIdOrganizacion(id);

        for (ReportOrganizacion reporte : reportesOrganizacion){
            map.put(reporte.getFechaGeneracion().toString(), reporte.getHuellaCarbono());
        }
        report.setReporte(map);
        return report;
    }

    public ReportDTO getReportMiembro(Integer id,ReportDTO report){
        Map<String, Double> map = new HashMap<String, Double>();
        List<ReportMiembro> reportesMiembros = new ArrayList<ReportMiembro>();
        reportesMiembros = repositoryMiembro.getAllReportesByIdMiembro(id);

        for (ReportMiembro reporte : reportesMiembros){
            map.put(reporte.getFechaGeneracion().toString(), reporte.getHuellaCarbono());
        }
        report.setReporte(map);
        return report;
    }
}
