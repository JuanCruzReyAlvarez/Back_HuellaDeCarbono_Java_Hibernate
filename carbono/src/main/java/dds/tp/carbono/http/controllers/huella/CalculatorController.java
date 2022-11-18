package dds.tp.carbono.http.controllers.huella;



import dds.tp.carbono.entities.huella.HuellaCarbono;

import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.huella.CalculatorDTO;
import dds.tp.carbono.http.dto.huella.RTACalculatorDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.MiembroService;
import dds.tp.carbono.services.huella.CalculatorService;
import dds.tp.carbono.services.organizacion.OrganizacionService;
import dds.tp.carbono.services.organizacion.SectorService;
import dds.tp.carbono.services.reportes.ServicioReportes;
import spark.Request;
import spark.Response;
import spark.Spark;



public class CalculatorController extends Controller {

    CalculatorService service;
    OrganizacionService organizacionService; 
    MiembroService miembrosService;
    SectorService sectorService;
    ServicioReportes serviceReport;

    
    public CalculatorController ( CalculatorService service
                                , OrganizacionService organizacionService
                                , MiembroService miembrosService
                                , SectorService sectorService
                                , ServicioReportes serviceReport){
        this.service = service;
        this.organizacionService = organizacionService;
        this.miembrosService = miembrosService;
        this.sectorService = sectorService;
        this.serviceReport = serviceReport;
        
    }

    @Override
    public void routes() {
    
        Spark.post(path(Uri.CALCULATOR), (rq, rs) -> this.calculate(rq, rs));    
    }

  public String calculate(Request request, Response response) throws HttpException {
        
    try {
        
        CalculatorDTO input = getBody(request, CalculatorDTO.class, null);
    
        System.out.println(input.getCalculoSolicitado());
        
        System.out.println(input.getFormaCalculo());
        System.out.println(input.getMiembroId());
        System.out.println(input.getOrganizacionId());
        System.out.println(input.getSectorId());
        System.out.println(input.getInicioPeriodo());

        RTACalculatorDTO DTO = new RTACalculatorDTO();
        HuellaCarbono hc = new HuellaCarbono();

        switch(input.getCalculoSolicitado()){

            
            case "ORGANIZACION":               
                hc = service.calculateOrg(input);
                serviceReport.saveToReportOrganizacion(hc,Integer.parseInt(input.getOrganizacionId()));
            break;
            case "MIEMBRO":
                hc = service.calculateMiembro(input);
                serviceReport.saveToReportMiembro(hc,Integer.parseInt(input.getMiembroId()));
                break;
            case "SECTOR":
            hc = service.calculateSector(input);
            break;
            case "AGENTE_SECTORIAL":
                hc = service.calculateAgenteSectorial(input);
                
                break;
        
        }

        System.out.println("RESULTADO");
        DTO.setUnidad(String.valueOf(hc.getUnidad().nombre()));
        DTO.setValor(String.valueOf(hc.getValor()));
        return json(DTO);   
    } 
    
    catch (Exception ex) {
        System.out.println("Error IN CALCULATORS");
        
    }
    return json("error"); 

}
}
