package dds.tp.carbono.http.dto.org;

import lombok.Getter;
import lombok.Setter;

public class RequestReportDTO {
    @Getter @Setter private String rol;
    @Getter @Setter private String userId;
    @Getter @Setter private String tipoAgente;
    @Getter @Setter String territorioId;
}
