package dds.tp.carbono.entities.huella;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;

public class BuscadorMiembros {
    
    List<SolicitudVinculacion> solicitudes;
    
    public List<Miembro>buscarMiembroPorOrganizacion(Organizacion org){
       
            List<Miembro> miembros = new ArrayList<Miembro>();
            
            solicitudes = this.getSolicitudesOrganizacion(org);

            System.out.println("ACA NOSE COMO PERO LLEGOOOOOO444");

            org.getSectores().forEach(sector -> {
                miembros.addAll(this.solicitudes
                .stream()
                .filter(sol -> sol.getEstado().equals(EstadoSolicitudVinculacion.ACEPTADO) && sol.getSector().equals(sector))
                .map(sol -> sol.getMiembro())
                .collect(Collectors.toList()));
            });

            System.out.println("Funciono hasta aca");
    
            return miembros;
      
    }


    public List<SolicitudVinculacion> getSolicitudesOrganizacion(Organizacion org) {
        List<SolicitudVinculacion> solicitudes = new ArrayList<SolicitudVinculacion>();
        org.getSectores().forEach(a->solicitudes.addAll(a.getSolicitudes()));
        return solicitudes;
    }
}
