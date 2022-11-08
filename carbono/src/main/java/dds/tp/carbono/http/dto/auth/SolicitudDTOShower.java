package dds.tp.carbono.http.dto.auth;

import lombok.Getter;
import lombok.Setter;

public class SolicitudDTOShower {
    @Getter @Setter public String nombre;
    @Getter @Setter public String apellido;
    @Getter @Setter public String nroDocumento;
    @Getter @Setter public String sector;
    @Getter @Setter public String idReq;
    @Getter @Setter public String Estado;
    @Getter @Setter public String userId;
    @Getter @Setter public String idSector;
}
