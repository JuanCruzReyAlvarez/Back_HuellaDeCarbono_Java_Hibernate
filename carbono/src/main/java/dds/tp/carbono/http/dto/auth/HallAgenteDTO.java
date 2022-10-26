
package dds.tp.carbono.http.dto.auth;

import lombok.Getter;
import lombok.Setter;

public class HallAgenteDTO {
    @Getter @Setter private String rol;
    @Getter @Setter private String userId;
    @Getter @Setter private String flagSector; // P o M 
    @Getter @Setter private String idProvincia;
    @Getter @Setter private String idMunicipio;
}