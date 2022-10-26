package dds.tp.carbono.services.auth;

import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.organization.Clasificacion;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.TipoOrganizacion;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.repository.PuntoGeografico.PuntoGeograficoRepository;
import dds.tp.carbono.repository.auth.UsuarioRepository;
import dds.tp.carbono.repository.organization.OrganizacionRepository;
import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Pais;
import dds.tp.carbono.services.external.dto.Provincia;

public class HallOrganizacionService {

    OrganizacionRepository repository;
    PuntoGeograficoRepository pgrepository;
    UsuarioRepository urepository;
    

    public HallOrganizacionService(){
        this.repository = new OrganizacionRepository();
        this.pgrepository = new PuntoGeograficoRepository();
        this.urepository = new UsuarioRepository();
    }

    public Organizacion register(String razonSocial, String clasficacion, String calle, String altura, 
                                    String localidad, String municipio, String provincia,String tipoOrganizacion, String user) {

		PuntoGeografico ubicacion = this.buildUbi(calle,altura,localidad,municipio,provincia,"Argentina");
        
        this.pgrepository.saveOne(ubicacion);                                  
    System.out.println("2");
        Organizacion organizacion = this.buildOrg(razonSocial, clasficacion,ubicacion,tipoOrganizacion,user);
                                                    
        return this.repository.guardar(organizacion);
    }


    private PuntoGeografico buildUbi(String calle, String altura, String idLocalidad, String idMunicipio, String idProvincia, String pais) {
        PuntoGeografico ubi = new PuntoGeografico();
        System.out.println(calle);
       
        ubi.setCalle(calle);
    
        ubi.setAltura(altura);
        System.out.println("3");

        Pais p = new Pais(pais);// id pais 1
        p.setId(1);
  
        Provincia pr = new Provincia();

        System.out.println(idProvincia);

        pr.setId(Integer.parseInt(idProvincia));


        pr.setPais(p);

        Municipio m = new Municipio();
       
        m.setId(Integer.parseInt(idMunicipio));
        m.setProvincia(pr);
        
        Localidad l = new Localidad();
   

        l.setId(Integer.parseInt(idLocalidad));

        l.setMunicipio(m);
    
        ubi.setLocaldiad(l);
        
		return ubi;
	}

    private Organizacion buildOrg(String razonSocial, String clasficacion, PuntoGeografico ubicacion, String tipoOrganizacion, String user) {
		Organizacion org = new Organizacion();
        org.org();
        org.setRazonSocial(razonSocial);
        org.setClasificacion(new Clasificacion(clasficacion));
        org.setUbicacion(ubicacion);
        org.setTipo(TipoOrganizacion.valueOf(tipoOrganizacion.toUpperCase()));
    
        System.out.println("4");
        System.out.println(user);
        Usuario usuario = urepository.getUsuarioById(Integer.parseInt(user));
        
        org.setUser(usuario);
        System.out.println("6");


        
        return org;
	}


}

	
