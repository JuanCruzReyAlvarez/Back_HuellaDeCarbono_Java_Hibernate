package dds.tp.carbono;

import java.util.List;

import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Pais;
import dds.tp.carbono.services.external.dto.Provincia;
import lombok.Getter;
import lombok.Setter;

//SINGLETON
public class GeoInfo {
    
    private static GeoInfo instance;

    @Getter @Setter private List<Pais> paises;
    @Getter @Setter private List<Provincia> provincias;
    @Getter @Setter private List<Municipio> municipios;
    @Getter @Setter private List<Localidad> localidades;


    public static GeoInfo getInstance() {
        if (instance == null)
            instance = new GeoInfo();

        return instance;
    } 
}

