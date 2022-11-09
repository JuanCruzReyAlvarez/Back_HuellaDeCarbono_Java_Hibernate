package dds.tp.carbono.http.controllers.org;

import dds.tp.carbono.services.MiembroService;
import dds.tp.carbono.services.organizacion.SectorService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;

import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.http.controllers.Controller;
import dds.tp.carbono.http.dto.huella.CalculatorDTO;
import dds.tp.carbono.http.dto.member.trayectos.MiembroDTO;

import dds.tp.carbono.http.utils.Uri;
import spark.Spark;
import spark.Request;
import spark.Response;

public class MiembroController extends Controller{  
    private MiembroService service; // dsp lo saco
    private SectorService sectorService;

    public MiembroController( MiembroService ms,SectorService ss ) { 
        this.service = ms;
        this.sectorService = ss;
    }
    
    @Override
    public void routes() {
        
        Spark.post(path(Uri.MEMBER), (rq, rs) -> this.getMiembrosbyOrg(rq, rs));
            
    }

    private String getMiembrosbyOrg(Request rq, Response rs) throws Exception {
        try{

            List<Miembro> miembros = new ArrayList<Miembro>();
            List<MiembroDTO> listaDTO = new ArrayList<MiembroDTO>();

            CalculatorDTO input = getBody(rq, CalculatorDTO.class, null);
    
            List<Sector> sectores = sectorService.getByOrg(Integer.parseInt(input.getOrganizacionId()));
    
            for (Sector sector: sectores){
                List<SolicitudVinculacion> solicitudes = sector.getSolicitudes().stream()
                                                            .filter(s->s.getEstado().equals(EstadoSolicitudVinculacion.ACEPTADO))
                                                            .collect(Collectors.toList());
                for(SolicitudVinculacion s:solicitudes)
                 miembros.add(s.getMiembro()); 
            }

           for (Miembro m:miembros){
                MiembroDTO obj= new MiembroDTO();
                               
                obj.setId(String.valueOf(m.getId()));
                obj.setName(m.getNombre() +" "+ m.getApellido());
                
                listaDTO.add(obj);
            }
                
                
                return json(listaDTO); 

            }catch(Exception exc){
                throw new Exception("In catch Exception geting Organizaciones was fail: ");
            }  
    }
}


   




   
