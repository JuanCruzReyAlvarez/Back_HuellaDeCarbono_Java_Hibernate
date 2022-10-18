package dds.tp.carbono.http.controllers.huella;



import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.huella.CalculatorDTO;
import dds.tp.carbono.http.exceptions.HttpException;
import dds.tp.carbono.http.utils.Uri;
import dds.tp.carbono.services.MiembroService;
import dds.tp.carbono.services.huella.CalculatorService;
import dds.tp.carbono.services.organizacion.OrganizacionService;
import dds.tp.carbono.services.organizacion.SectorService;
import spark.TemplateEngine;
import spark.Request;
import spark.Response;
import spark.Spark;



public class CalculatorController extends Controller {

    CalculatorService service;
    OrganizacionService organizacionService; //ACTUALIZAR EN EL CONTROLER RUTAS
    MiembroService miembrosService;
    SectorService sectorService;
    
    public CalculatorController ( CalculatorService service, OrganizacionService organizacionService, MiembroService miembrosService,   SectorService sectorService){
        this.service = service;
        this.organizacionService = organizacionService;
        this.miembrosService = miembrosService;
        this.sectorService = sectorService;
        
    }

    @Override
    public void routes(TemplateEngine engine) {
        
        Spark.post(path(Uri.ORGANIZACION), (rq, rs) -> this.getOrganizaciones(rq, rs));
        Spark.post(path(Uri.CALCULATOR), (rq, rs) -> this.calculate(rq, rs));
        Spark.post(path(Uri.MEMBER), (rq, rs) -> this.getMiembros(rq, rs));
        Spark.post(path(Uri.SECTORES), (rq, rs) -> this.getSectores(rq, rs));
        
    }


    private Object getSectores(Request request, Response rs) throws HttpException {
		
        CalculatorDTO input = getBody(request, CalculatorDTO.class, null);

        List<Sector> sectores = sectorService.getByOrg(Integer.parseInt(input.getOrganizacionId()));
        

        return json(sectores);
	}

	private String getMiembros(Request request, Response rs) throws HttpException {

        List<Miembro> miembros = null;

        CalculatorDTO input = getBody(request, CalculatorDTO.class, null);

        List<Sector> sectores = sectorService.getByOrg(Integer.parseInt(input.getOrganizacionId()));

        for (Sector sector: sectores){
            List<SolicitudVinculacion> solicitudes = sector.getSolicitudes().stream()
                                                        .filter(s->s.getEstado().equals(EstadoSolicitudVinculacion.ACEPTADO))
                                                        .collect(Collectors.toList());
            for(SolicitudVinculacion s:solicitudes)
             miembros.add(s.getMiembro()); //ojo
        }

		return json(miembros);
	}

	private String getOrganizaciones(Request rq, Response rs) throws Exception {
        try{
                List<Organizacion> organizaciones = organizacionService.getAll();            
                return json(organizaciones); 
            }catch(Exception exc){
                throw new Exception("In catch Exception geting Organizaciones was fail: ");
            }  
    }
   

    public String calculate(Request request, Response response) throws HttpException {
        
        try {
            
            CalculatorDTO input = getBody(request, CalculatorDTO.class, null);
            HuellaCarbono hc = new HuellaCarbono();

            switch(input.getCalculoSolicitado()){

                case "ORG":               
                hc = service.calculateOrg(input);
                case "MIEMBRO":
                hc = service.calculateSector(input);
                case "SECTOR":
                hc = service.calculateMiembro(input);
            
            }
            return json(hc);   
        } 
        
        catch (Exception ex) {
            System.out.println("Error IN CALCULATORS");
            
        }
        return json("error"); //puede fallar

    }}

   