package dds.tp.carbono.services.reportes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.http.dto.org.HuellaReporteDTO;
import dds.tp.carbono.http.dto.org.ReportDTO;
import dds.tp.carbono.repository.PuntoGeografico.MunicipioRepository;
import dds.tp.carbono.repository.PuntoGeografico.ProvinciaRepository;
import dds.tp.carbono.repository.member.ReportMiembroRepository;
import dds.tp.carbono.repository.organization.ReportOrganizacionRepository;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;

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
        List<HuellaReporteDTO> listaDeReportes = new ArrayList<HuellaReporteDTO>();
        List<ReportOrganizacion>reportesOrganizacion = new ArrayList<ReportOrganizacion>();
        reportesOrganizacion = repositoryOrganizacion.getAllReportesByIdOrganizacion(id);

        for (ReportOrganizacion reporte : reportesOrganizacion){
            HuellaReporteDTO valorHuella = new HuellaReporteDTO();
            valorHuella.setFecha(reporte.getFechaGeneracion().toString());
            valorHuella.setValor(Double.toString(reporte.getHuellaCarbono()));
            listaDeReportes.add(valorHuella);
        }
        report.setReporte(listaDeReportes);
        return report;
    }


    public ReportDTO getReportMiembro(Integer id,ReportDTO report){
        List<HuellaReporteDTO> listaDeReportes = new ArrayList<HuellaReporteDTO>();
        List<ReportMiembro> reportesMiembros = new ArrayList<ReportMiembro>();
        reportesMiembros = repositoryMiembro.getAllReportesByIdMiembro(id);

        for (ReportMiembro reporte : reportesMiembros){
            HuellaReporteDTO valorHuella = new HuellaReporteDTO();
            valorHuella.setFecha(reporte.getFechaGeneracion().toString());
            valorHuella.setValor(Double.toString(reporte.getHuellaCarbono()));
            listaDeReportes.add(valorHuella);
        }
        report.setReporte(listaDeReportes);
        return report;
    }


    public ReportDTO getReportAgenteSectorial(ReportDTO report, SectorTerritorial sector, String tipoAgente, String idTerritorio ){
        ReportOrganizacionRepository repoorgrepository = new ReportOrganizacionRepository();
        List<HuellaReporteDTO> listaDeReportes = new ArrayList<HuellaReporteDTO>();
        List<ReportOrganizacion>reportesOrganizacion = new ArrayList<ReportOrganizacion>();
        switch (tipoAgente) {
            case "PROVINCIAL":
                    System.out.println("Entre al provincial");

                    Provincia provincia = new Provincia();
                    ProvinciaRepository provinciaRepository = new ProvinciaRepository();
                    System.out.println(idTerritorio);
                    provincia =  provinciaRepository.getByIdProvincia(Integer.parseInt(idTerritorio));
                    System.out.println("Paso1,5");
                    System.out.println(provincia.getId());
                    reportesOrganizacion = repoorgrepository.getAllReportesByProvinciaOrganizacion(provincia.getId());
                    System.out.println("PASO 2 ");

                    for (ReportOrganizacion reporte : reportesOrganizacion){
                        HuellaReporteDTO valorHuella = new HuellaReporteDTO();
                        valorHuella.setFecha(reporte.getFechaGeneracion().toString());
                        valorHuella.setValor(Double.toString(reporte.getHuellaCarbono()));
                        listaDeReportes.add(valorHuella);
                    }
                    System.out.println("PASO 1");
                    report.setReporte(listaDeReportes);
                return report;
            case "MUNICIPAL":
                    MunicipioRepository municipioRepository = new MunicipioRepository();
                    Municipio municipio = new Municipio();
                    municipio =  municipioRepository.getByIdMunicipio(Integer.parseInt(idTerritorio));
                    reportesOrganizacion = repoorgrepository.getAllReportesByMunicipioOrganizacion(municipio.getId());
                    for (ReportOrganizacion reporte : reportesOrganizacion){
                        HuellaReporteDTO valorHuella = new HuellaReporteDTO();
                        valorHuella.setFecha(reporte.getFechaGeneracion().toString());
                        valorHuella.setValor(Double.toString(reporte.getHuellaCarbono()));
                        listaDeReportes.add(valorHuella);
                    } 
                    report.setReporte(listaDeReportes);
             
                    return report;

                
        }
        return null;
    }

}
