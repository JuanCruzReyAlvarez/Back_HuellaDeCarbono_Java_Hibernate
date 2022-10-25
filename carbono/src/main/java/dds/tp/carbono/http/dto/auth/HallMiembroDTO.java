
package dds.tp.carbono.http.dto.auth;

import lombok.Getter;
import lombok.Setter;

public class HallMiembroDTO {
    @Getter @Setter private String rol;
    @Getter @Setter private String userId ; 
    @Getter @Setter private String nombre;
    @Getter @Setter private String apellido;
    @Getter @Setter private String idOrganizacion;
    @Getter @Setter private String idSector;
    @Getter @Setter private String tipoDocumento;
    @Getter @Setter private String nroDocumento;
    @Getter @Setter private String flagSolicitud;
}
