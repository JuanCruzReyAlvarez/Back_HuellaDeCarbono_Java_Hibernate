package dds.tp.carbono.http.controllers.reportes;

import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.org.ReportDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.repository.member.MiembroRepository;
import dds.tp.carbono.repository.organization.OrganizacionRepository;
import dds.tp.carbono.services.agenteSectorial.AgenteSectorialService;
import dds.tp.carbono.services.reportes.ServicioReportes;
import dds.tp.carbono.http.dto.org.RequestReportDTO;
import spark.Request;
import spark.Response;
import spark.Spark;

public class ReportesController extends Controller{

        ServicioReportes serviceReport;
    
        public ReportesController( ServicioReportes serviceReport) { 
                this.serviceReport = serviceReport;
        }
    
        @Override
        public void routes() {
            Spark.post(path(Uri.ORG_REPORT), (rq, rs) -> this.orgReport(rq, rs));
        }
    
        private String orgReport(Request rq, Response rs) throws HttpException {
            try{
                    RequestReportDTO input = getBody(rq, RequestReportDTO.class,null); 
                    ReportDTO report = new ReportDTO();

                    System.out.println("Entro");


                    switch (input.getRol()) {
                        case "ORGANIZACION": 
                            OrganizacionRepository orgrep = new OrganizacionRepository();
                            Organizacion orgg = orgrep.getByUser(Integer.parseInt(input.getUserId()));
                            report = serviceReport.getReportOrganizacion(orgg.getId(),report);
                            break;
                        case "MIEMBRO": 
                            MiembroRepository miemrep = new MiembroRepository();
                            Miembro miemm = miemrep.getByUserId((Integer.parseInt(input.getUserId())));
                            report = serviceReport.getReportMiembro(miemm.getId(),report);
                            break;
                        case "AGENTE_SECTORIAL": 
                            System.out.println("Entre a paso 0");
                            AgenteSectorialService agenteService = new AgenteSectorialService();
                            SectorTerritorial sector = agenteService.getSectorById(Integer.parseInt(input.getUserId()));
                            report = serviceReport.getReportAgenteSectorial(report,sector,input.getTipoAgente(),input.getTerritorioId());
                            break;
                    }
                    
                    return json(report);
                    
                   
                }catch(Exception exc){
                    System.out.println("In catch Exception creating sector in controler was fail:");
                }  
            return null;
        }

}
