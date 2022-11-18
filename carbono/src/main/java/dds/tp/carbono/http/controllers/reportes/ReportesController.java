package dds.tp.carbono.http.controllers.reportes;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.org.ReportDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.repository.member.MiembroRepository;
import dds.tp.carbono.repository.organization.OrganizacionRepository;
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
            Spark.get(path(Uri.ORG_REPORT), (rq, rs) -> this.orgReport(rq, rs));
        }
    
        private String orgReport(Request rq, Response rs) throws HttpException {
            try{
                    RequestReportDTO input = getBody(rq, RequestReportDTO.class,null); 
                    ReportDTO report = new ReportDTO();


                    switch (input.getFlag()) {
                        case "O": 
                            OrganizacionRepository orgrep = new OrganizacionRepository();
                            Organizacion orgg = orgrep.getByUser(Integer.parseInt(input.getUserId()));
                            report = serviceReport.getReportOrganizacion(orgg.getId(),report);
                            break;
                        case "M": 
                            MiembroRepository miemrep = new MiembroRepository();
                            Miembro miemm = miemrep.getByUserId((Integer.parseInt(input.getUserId())));
                            report = serviceReport.getReportMiembro(miemm.getId(),report);
                            break;
                    }
                   
                    return json(report);
                    
                   
                }catch(Exception exc){
                    System.out.println("In catch Exception creating sector in controler was fail:");
                }  
            return null;
        }

}
