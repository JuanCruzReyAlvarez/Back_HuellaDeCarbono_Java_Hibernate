
package dds.tp.carbono.http.dto.auth;

import lombok.Getter;
import lombok.Setter;

public class HallOrgDTO {
    @Getter @Setter private String rol;
    @Getter @Setter private String userId ; 
    @Getter @Setter private String razonSocial;
    @Getter @Setter private String clasificacion;
    @Getter @Setter private String calle;
    @Getter @Setter private String altura;
    @Getter @Setter private String idProvincia;
    @Getter @Setter private String idMunicipio;
    @Getter @Setter private String idlocalidad;
    @Getter @Setter private String tipoOrganizacion;
}
