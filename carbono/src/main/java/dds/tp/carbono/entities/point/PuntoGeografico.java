package dds.tp.carbono.entities.point;

import dds.tp.carbono.services.external.dto.Localidad;
import lombok.Getter;
import lombok.Setter;

public class PuntoGeografico {
    @Getter @Setter private Integer id;
    @Getter @Setter private Integer idLocalidad;
    @Getter @Setter private String direccion;
    @Getter @Setter private Double latitud;
    @Getter @Setter private Double longitud;
    @Getter @Setter private String calle;
    @Getter @Setter private String altura;
    @Getter @Setter private Localidad localdiad;

    
}
