package dds.tp.carbono.services.ubicacion;

import java.util.List;
import java.util.Set;

import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;

public class UbicacionesCacheDecorator implements UbicacionesService {
 
    private UbicacionesCache cache;
    private UbicacionesService source;

    public UbicacionesCacheDecorator() {
        this.cache = UbicacionesCache.instance();
        this.source = new UbicacionesServicioExterno();
    }

    @Override
    public List<Provincia> listadoDeProvincias() throws Exception {
        Set<Provincia> provincias = this.cache.getProvincias();
        
        if (provincias.size() == 0)
            this.cache.addProvincias(this.source.listadoDeProvincias());
        
        return List.copyOf(this.cache.getProvincias());
    }

    @Override
    public List<Municipio> listadoDeMunicipios(Provincia provincia) throws Exception {
        Set<Municipio> municipios = this.cache.getMunicipios(provincia);
        
        if (municipios.size() == 0)
            this.cache.addMunicipios(this.source.listadoDeMunicipios(provincia));
        
        return List.copyOf(this.cache.getMunicipios(provincia));
    }

    @Override
    public List<Localidad> listadoDeLocalidades(Municipio municipio) throws Exception {
        Set<Localidad> localidades = this.cache.getLocalidades(municipio);
        
        if (localidades.size() == 0)
            this.cache.addLocalidades(this.source.listadoDeLocalidades(municipio));
        
        return List.copyOf(this.cache.getLocalidades(municipio));
    }
}
