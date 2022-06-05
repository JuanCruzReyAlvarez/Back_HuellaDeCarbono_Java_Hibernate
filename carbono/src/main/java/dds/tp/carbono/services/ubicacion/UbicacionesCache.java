package dds.tp.carbono.services.ubicacion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;
import lombok.Getter;

public class UbicacionesCache {
    
    private static UbicacionesCache instance;
    public static UbicacionesCache instance() {
        if (instance == null) 
            instance = new UbicacionesCache();

        return instance;
    }

    private UbicacionesCache() {
        this.provincias = new HashSet<Provincia>();
        this.municipios = new HashSet<Municipio>();
        this.localidades = new HashSet<Localidad>();
    }

    @Getter private Set<Provincia> provincias;
    private Set<Municipio> municipios;
    private Set<Localidad> localidades;

    public void addProvincias(List<Provincia> provincias) {
        this.provincias.addAll(provincias);
    }

    public void addMunicipios(List<Municipio> municipios) {
        this.municipios.addAll(municipios);
    }

    public void addLocalidades(List<Localidad> localidades) {
        this.localidades.addAll(localidades);
    }

    public Set<Municipio> getMunicipios(Provincia provincia) {
        return this.municipios.stream().filter(muni -> muni.getProvincia().getId().equals(provincia.getId())).collect(Collectors.toSet());
    }

    public Set<Localidad> getLocalidades(Municipio municipio) {
        return this.localidades.stream()
                              .filter(loc -> loc.getMunicipio().getId().equals(municipio.getId()))
                              .collect(Collectors.toSet());
    }
}
