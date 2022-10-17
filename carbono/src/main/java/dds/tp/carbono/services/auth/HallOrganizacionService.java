package dds.tp.carbono.services.auth;

import dds.tp.carbono.entities.organization.Clasificacion;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.TipoOrganizacion;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.repository.organization.OrganizacionRepository;
import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Pais;
import dds.tp.carbono.services.external.dto.Provincia;

public class HallOrganizacionService {

    OrganizacionRepository repository;

    public HallOrganizacionService(){
        this.repository = new OrganizacionRepository();
    }

    public Organizacion register(String razonSocial, String clasficacion, String calle, String altura, 
                                    String localidad, String municipio, String provincia, String pais,String tipoOrganizacion) {

		PuntoGeografico ubicacion = this.buildUbi(calle,altura,localidad,municipio,provincia,pais);
        Organizacion organizacion = this.buildOrg(razonSocial, clasficacion,ubicacion,tipoOrganizacion);
        return this.repository.guardar(organizacion);
    }


    private PuntoGeografico buildUbi(String calle, String altura, String localidad, String municipio, String provincia, String pais) {
        PuntoGeografico ubi = new PuntoGeografico();
        ubi.setCalle(calle);
        ubi.setAltura(altura);

        Pais p = new Pais(pais);
        Provincia pr = new Provincia();
        pr.setNombre(provincia);
        pr.setPais(p);
        Municipio m = new Municipio(municipio);
        m.setProvincia(pr);
        Localidad l = new Localidad(localidad);
        l.setMunicipio(m);
        ubi.setLocaldiad(l);
        
		return ubi;
	}

    private Organizacion buildOrg(String razonSocial, String clasficacion, PuntoGeografico ubicacion, String tipoOrganizacion) {
		Organizacion org = new Organizacion();
        org.setRazonSocial(razonSocial);
        org.setClasificacion(new Clasificacion(clasficacion));
        org.setUbicacion(ubicacion);
        org.setTipo(TipoOrganizacion.valueOf(tipoOrganizacion.toUpperCase()));
        
        return org;
	}


}

	
