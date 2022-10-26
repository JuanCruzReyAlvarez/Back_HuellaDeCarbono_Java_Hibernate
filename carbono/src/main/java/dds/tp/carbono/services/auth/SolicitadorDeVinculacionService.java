package dds.tp.carbono.services.auth;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.repository.organization.SolicitudVinculacionRepository;



public class SolicitadorDeVinculacionService {
    
    SolicitudVinculacionRepository repository;

    public SolicitadorDeVinculacionService () {
        this.repository = new SolicitudVinculacionRepository();
    }


    /* 
    public SolicitadorDeVinculacion create(String idOrganizacionSol, String idSectorSol, Miembro miembro) {
        SolicitadorDeVinculacion solicitud = this.buildSolcitud(idOrganizacionSol, idSectorSol, miembro);
    return this.repository.crearSolicitud(solicitud);
    }
    */


    public SolicitudVinculacion solicitarVinculacionInicialPorHall(Sector sector, Miembro miembro) throws Exception {
        
        SolicitudVinculacion solicitud = new SolicitudVinculacion(miembro, sector);
        System.out.println("en el serviceeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee ");
        return this.repository.crearSolicitud(solicitud);        
    }

    

    public SolicitudVinculacion solicitarVinculacionDesdeWeb( Sector sector, Miembro miembro) throws Exception {
        if (this.repository.existsSolicitud(miembro, sector))
            throw new Exception("Solicitud a estaba Pendiente/Aceptada");
        SolicitudVinculacion solicitud = new SolicitudVinculacion(miembro, sector);
        return this.repository.crearSolicitud(solicitud);        
    }





}
