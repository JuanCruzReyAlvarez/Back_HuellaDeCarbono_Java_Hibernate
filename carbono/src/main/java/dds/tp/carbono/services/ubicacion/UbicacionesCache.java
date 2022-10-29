package dds.tp.carbono.services.ubicacion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;
import dds.tp.carbono.services.external.puntoGeografico.LocalidadService;
import dds.tp.carbono.services.external.puntoGeografico.MunicipioService;
import dds.tp.carbono.services.external.puntoGeografico.ProvinciaService;


public class UbicacionesCache {
    
    private static UbicacionesCache instance;

    public ProvinciaService provinciaService;
    public MunicipioService municipioService;
    public LocalidadService localidadService;
    
    private Set<Provincia> provincias;
    private Set<Municipio> municipios;
    private Set<Localidad> localidades;

    public static UbicacionesCache instance(){ 
        if (instance == null){
            instance = new UbicacionesCache();
        }
        return instance;
    }

    private UbicacionesCache() {

        this.provinciaService = new ProvinciaService ();
        this.municipioService = new MunicipioService ();
        this.localidadService = new LocalidadService ();

        // LISTAS PARA TESTEAR EN DESARROLLO SIN BASA DE DATOS:

        this.provincias = new HashSet<Provincia>();
        this.municipios = new HashSet<Municipio>();
        this.localidades = new HashSet<Localidad>();
    }

    public void addProvincias(List<Provincia> provincias) {

        this.provincias.addAll(provincias); //Para test De Desarrollo
        //for (Provincia p : provincias){
            //System.out.println(p.getNombre());
            //System.out.println(p.getId());
           // System.out.println(p.getPais());
        //}
        
        this.provinciaService.saveAll(provincias);
    }

    public void addMunicipios(List<Municipio> municipios) {
        this.municipios.addAll(municipios);
        this.municipioService.SaveAll(municipios);
    }

    public void addLocalidades(List<Localidad> localidades) {
        this.localidades.addAll(localidades);
        this.localidadService.saveAll(localidades);
    }

    public Set<Municipio> getMunicipios() {
        return this.municipios;
    }
    public Set<Localidad> getLocalidades() {
        return this.localidades;
    }
    public Set<Provincia> getProvincias() {
        return this.provincias;
    }

    // Metodos para Tests De Desarrollo:

    public Set<Municipio> getMunicipiosByProvincia(Provincia provincia) {
        return this.municipios.stream().filter(muni -> muni.getProvincia().getId().equals(provincia.getId())).collect(Collectors.toSet());
    }

    public Set<Localidad> getLocalidadesByMunicipio(Municipio municipio) {
        return this.localidades.stream()
                              .filter(loc -> loc.getMunicipio().getId().equals(municipio.getId()))
                              .collect(Collectors.toSet());
    }



}
