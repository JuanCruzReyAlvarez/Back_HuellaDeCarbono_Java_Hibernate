package dds.tp.carbono.http.dto.member.trayectos;

import lombok.Getter;
import lombok.Setter;

public class TrayectoDTO {
    @Getter @Setter private Integer id;
    @Getter @Setter private String desde;
    @Getter @Setter private String hasta;
    @Getter @Setter private Integer nroDeTramos;

    public TrayectoDTO(Integer id, String desde, String hasta, Integer nroDeTramos) {
        this.id = id;
        this.desde = desde;
        this.hasta = hasta;
        this.nroDeTramos = nroDeTramos;
    }
}
