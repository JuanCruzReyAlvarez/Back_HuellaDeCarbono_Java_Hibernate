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
        ProvinciaRepository provRepo = new ProvinciaRepository();
        municipioOrg = this.source.listadoDeMunicipios();
        Provincia p = new Provincia();
        String provin = "BUENOS AIRES";
        p.setId(provRepo.getIdByName(provin));
        p.setNombre(provin);
        Municipio a = new Municipio("LEANDRO N. ALEM",p);
        Municipio b = new Municipio("LIBERTADOR GENERAL SAN MARTIN",p);      //Es necesario agregar estos municipios porque la API es trucha
        Municipio c = new Municipio("CONFLUENCIA",p);                        // nos da municipios de localidades , de municipios que no nos da
        Municipio d = new Municipio("LA PAZ",p);                             // cuando los pedimos solo municipios, presenta inconsistencia, lo arreglamos
        Municipio e = new Municipio("PACLIN",p);                             // nosotros ya que necesitamos que la appi funcione bien.
        municipioArreglados.add(a);
        municipioArreglados.add(b); 
        municipioArreglados.add(c); 
        municipioArreglados.add(d);
        municipioArreglados.add(e);      
        for(Municipio o : municipioOrg){

                Municipio muni = new Municipio();
                ProvinciaRepository repo = new ProvinciaRepository();
                Provincia prov = new Provincia();

                muni.setNombre(o.getNombre());    
                prov.setId(repo.getIdByName(o.getProvincia().getNombre()));    
                muni.setProvincia(prov);
                municipioArreglados.add(muni);
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
        
        localidadOrg = this.source.listadoDeLocalidades();
        System.out.println("LLEGUE ACAAAAAAAAAAAAAAAAAA 1 ");    
            for(Localidad l : localidadOrg){

                Localidad loc = new Localidad();
                MunicipioRepository repo = new MunicipioRepository ();
                Municipio muni = new Municipio();

                loc.setNombre(l.getNombre()); 
                System.out.println(l.getNombre());  

                muni.setId(repo.getIdByName(l.getMunicipio().getNombre())); 
                System.out.println(repo.getIdByName(l.getMunicipio().getNombre())); 
                loc.setMunicipio(muni);
                localidadesArreglados.add(loc);
            }
            System.out.println("LLEGUE ACAAAAAAAAAAAAAAAAAA 2 "); 
            this.cache.addLocalidades(localidadesArreglados);
            System.out.println("LLEGUE ACAAAAAAAAAAAAAAAAAA 3 "); 
        }
        return this.cache.getLocalidades().stream().collect(Collectors.toList());
    }
}
