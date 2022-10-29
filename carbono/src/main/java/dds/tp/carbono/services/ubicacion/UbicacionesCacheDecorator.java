package dds.tp.carbono.services.ubicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import dds.tp.carbono.repository.PuntoGeografico.MunicipioRepository;
import dds.tp.carbono.repository.PuntoGeografico.ProvinciaRepository;
import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Pais;
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

        if (provincias.size() == 0){
        
            List <Provincia> provinciasArregladas = new ArrayList<>();
            List <Provincia> provinciasOrg= new ArrayList<>();

            provinciasOrg = this.source.listadoDeProvincias();
            
            for(Provincia o : provinciasOrg){

                Provincia prov = new Provincia();
                Pais pais = new Pais();

                prov.setNombre(o.getNombre());
                pais.setNombre(o.getPais().getNombre());
                pais.setId(1);
                prov.setPais(pais);
                provinciasArregladas.add(prov);
            }

            this.cache.addProvincias(provinciasArregladas);

    }
            
        return this.cache.getProvincias().stream().collect(Collectors.toList());
    }

    @Override
    public List<Municipio> listadoDeMunicipios(Provincia provincia) throws Exception {

        Set<Municipio> municipios = this.cache.getMunicipiosByProvincia(provincia);
        
        if (municipios.size() == 0)
            this.cache.addMunicipios(this.source.listadoDeMunicipios(provincia));
        
        return this.cache.getMunicipiosByProvincia(provincia).stream().collect(Collectors.toList());
    }

    @Override
    public List<Localidad> listadoDeLocalidades(Municipio municipio) throws Exception {
        Set<Localidad> localidades = this.cache.getLocalidadesByMunicipio(municipio);
        
        if (localidades.size() == 0)
            this.cache.addLocalidades(this.source.listadoDeLocalidades(municipio));
        
        return this.cache.getLocalidadesByMunicipio(municipio).stream().collect(Collectors.toList());
    }

    @Override
    public List<Municipio> listadoDeMunicipios() throws Exception {
        Set<Municipio> municipios = this.cache.getMunicipios();
        

        if (municipios.size() == 0){

        List <Municipio> municipioArreglados = new ArrayList<>();
        List <Municipio> municipioOrg = new ArrayList<>();
        ProvinciaRepository repo = new ProvinciaRepository();
  
        List<Provincia> provincias = new ArrayList<>();        
        UbicacionesServicioExterno ubi= new UbicacionesServicioExterno();
        provincias = ubi.listadoDeProvincias();
        for (Provincia provi : provincias){

        municipioOrg = this.source.listadoDeMunicipios(provi);

        for(Municipio o : municipioOrg){
           

                Municipio muni = new Municipio();
  
                Provincia prov = new Provincia();

                muni.setNombre(o.getNombre());    
                System.out.println(o.getNombre());
                prov.setId(repo.getIdByName(o.getProvincia().getNombre()));   
                System.out.println(prov.getId());
                muni.setProvincia(prov);

                municipioArreglados.add(muni);
                System.out.println(municipioArreglados.size());
            

            }

            municipioOrg.removeAll(municipioOrg);
        }
        
        this.cache.addMunicipios(municipioArreglados);
        

    }
        return this.cache.getMunicipios().stream().collect(Collectors.toList());
    }

    @Override
    public List<Localidad> listadoDeLocalidades() throws Exception {
        Set<Localidad> localidades = this.cache.getLocalidades();

        
        if (localidades.size() == 0){

        List <Localidad> localidadesArreglados = new ArrayList<>();
        List <Localidad> localidadOrg = new ArrayList<>();
        List <Municipio> municipios = new ArrayList<>();
        MunicipioRepository repo = new MunicipioRepository ();


        UbicacionesServicioExterno ubi= new UbicacionesServicioExterno();
        municipios = ubi.listadoDeMunicipios();

        for (Municipio mun : municipios){

        localidadOrg = this.source.listadoDeLocalidades(mun);
    
            for(Localidad l : localidadOrg){

                Localidad loc = new Localidad();
                
                Municipio muni = new Municipio();

                loc.setNombre(l.getNombre()); 
                System.out.println(l.getNombre());  

                muni.setId(repo.getIdByName(l.getMunicipio().getNombre())); 
               
                loc.setMunicipio(muni);

                localidadesArreglados.add(loc);
            }

            localidadOrg.removeAll(localidadOrg);
        
        }

            this.cache.addLocalidades(localidadesArreglados);

        }
        return this.cache.getLocalidades().stream().collect(Collectors.toList());
    }
    

}
