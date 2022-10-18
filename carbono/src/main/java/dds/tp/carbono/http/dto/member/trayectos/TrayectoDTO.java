package dds.tp.carbono.http.dto.member.trayectos;

import java.util.List;

import dds.tp.carbono.entities.member.Tramo;
import lombok.Getter;
import lombok.Setter;

public class TrayectoDTO {
    @Getter @Setter private String idMiembro;
    @Getter @Setter private String desde;
    @Getter @Setter private String hasta;
    @Getter @Setter private List<Tramo> tramos; 
    @Getter @Setter private String acompañado; // VERDADERO O FALSO
    @Getter @Setter private String idCompañia;
    @Getter @Setter private String localidadDesdeId;
    @Getter @Setter private String localidadHastaId;

}
