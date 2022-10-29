package dds.tp.carbono.services.agenteSectorial;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.agenteSectorial.SectorMunicipal;
import dds.tp.carbono.entities.agenteSectorial.SectorProvincial;
import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.repository.agenteSectorial.SectorTerritorialRepository;
import dds.tp.carbono.repository.organization.OrganizacionRepository;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;

public class AsignadorDeAgentesSectoriales {

    private SectorTerritorialRepository repo;

    public AsignadorDeAgentesSectoriales() {
        this.repo = new SectorTerritorialRepository();
    }
   
    public SectorTerritorial asignar(Municipio municipio, Usuario usuario) throws Exception {
        

        System.out.println("HOLAAAAA  1");
        SectorTerritorial sector = repo.getBy(usuario);
        
        System.out.println("HOLAAAAA  2");
        if (sector == null) {
            SectorMunicipal sm = new SectorMunicipal();
            sm.setMunicipio(municipio);

            System.out.println(municipio.getId() + "ESTEEEEE ID ES IGUAL A ");

            sm.setUsuario(usuario);
            this.repo.guardar(sm);
            //sm.setOrganizaciones(this.asignarOrganiacionesProvincia(provincia));
            
            actualizarAsignacionesMunicipio(municipio,sm);
            
            return sm;
        }

        throw new Exception("Agente sectorial ya tenia asgnado sector territorial");
    }

    private void actualizarAsignacionesMunicipio(Municipio municipio, SectorMunicipal sm) {
        
        OrganizacionRepository os = new OrganizacionRepository();
        System.out.println("HOLAAAAA  4.1");


        List<Organizacion> organizacions =  os.getBy(municipio);
        System.out.println(organizacions.size());
        List<Organizacion> orgAGuardar = new ArrayList<>();


        for (Organizacion o : organizacions){
            System.out.println("HOLAAAAA  4.2");
            if(o.getUbicacion().getLocaldiad().getMunicipio().getId().equals(municipio.getId())){
                System.out.println("HOLAAAAA  4.3");
                 o.setSectorTerritorial(sm);
                 
                 orgAGuardar.add(o);


                 System.out.println("HOLAAAAA  4.4");
                 
                 
           }
       }

       os.saveAll(orgAGuardar);
       System.out.println("HOLAAAAA  4.5");
    
    }

    public SectorTerritorial asignar(Provincia provincia, Usuario usuario) throws Exception {
        
        
        SectorTerritorial sector = repo.getBy(usuario);
        
        
        if (sector == null) {
            SectorProvincial sm = new SectorProvincial();
            sm.setProvincia(provincia);
            sm.setUsuario(usuario);
            
            this.repo.guardar(sm);
                      
            //actualizarAsignacionesProvincia(provincia,sm);
            
            return sm;
        }
       

        throw new Exception("Agente sectorial ya tenia asgnado sector territorial");
    }

    /*private List<Organizacion> asignarOrganiacionesMunicipio(Municipio municipio){ 
        return new OrganizacionService().getBy(municipio);  
    }

    private List<Organizacion> asignarOrganiacionesProvincia(Provincia provincia){
        return new OrganizacionService().getBy(provincia); 
    }*/


    /*public void actualizarAsignacionesProvincia(Provincia provincia, SectorTerritorial sm){

        OrganizacionRepository os = new OrganizacionRepository();
        List<Organizacion> organizacions =  os.getBy(provincia);
       
        for (Organizacion o :organizacions ){
            
            if(o.getUbicacion().getLocaldiad().getMunicipio().getProvincia().getId().equals(provincia.getId())){
               
                 o.setSectorTerritorial(sm);
                 os.guardar(o);
                 
           }
       }
        
    }*/
}
