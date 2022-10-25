
package dds.tp.carbono.http.dto.auth;

import lombok.Getter;
import lombok.Setter;

public class HallAgenteDTO {
    @Getter @Setter private String idProvincia;
    @Getter @Setter private String idMunicipio;
    @Getter @Setter private String id;
    @Getter @Setter private String username;
}