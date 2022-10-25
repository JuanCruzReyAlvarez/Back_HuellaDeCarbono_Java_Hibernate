package dds.tp.carbono.http.dto.auth;

import lombok.Getter;
import lombok.Setter;

public class HallDTO {
    @Getter @Setter private String nombre;
    @Getter @Setter private String apellido;
    @Getter @Setter private String idOrganizacionSol;
    @Getter @Setter private String idSectorSol;
    @Getter @Setter private String tipoDocumento;
    @Getter @Setter private String nroDocumento;
    @Getter @Setter private String rol;
    @Getter @Setter private String flagSolicitud;
    //sector
 
    @Getter @Setter private String idSector;
    //org
    @Getter @Setter private String razonSocial;
    @Getter @Setter private String clasficacion;
    @Getter @Setter private String tipoOrganizacion;
    
    //localidad org - agente
    

    @Getter @Setter private String calle;
    @Getter @Setter private String altura;
    @Getter @Setter private String pais;
    @Getter @Setter private String provincia;//no
    @Getter @Setter private String municipio;//no
    @Getter @Setter private String idPais;

    @Getter @Setter private String idProvincia;
    @Getter @Setter private String idMunicipio;

    @Getter @Setter private String idlocalidad;

    //agente
    @Getter @Setter private String tipoSectorACargo;



}
