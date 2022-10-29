package dds.tp.carbono.repository.organization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.dao.org.OrganizacionDao;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;

public class OrganizacionRepository {

    private OrganizacionDao dao; 

    public OrganizacionRepository() {
        this.dao = OrganizacionDao.getInstance();
        this.dao.setClazz(Organizacion.class);
    }

    public Organizacion guardar(Organizacion organizacion) {
        return this.dao.save(organizacion); 
    }

    public boolean exists(String razonSocial) {
        return this.dao.getAll().stream().anyMatch(o -> o.getRazonSocial().equals(razonSocial));
    }

    public void addMetrics(List<MetricaOrganizacion> metricas, Organizacion organizacion) {
        Organizacion org = this.dao.getAll()
            .stream().filter(o -> o.getRazonSocial().equals(organizacion.getRazonSocial()))
            .findFirst().orElse(null);
        
        if (org != null) {
            org.addMetricas(metricas);
            this.dao.update(org);
        }
    }

    public Organizacion getByUser(Usuario user) {
        return this.dao.getAll().stream().filter(o -> o.getUser().equals(user)).findFirst().orElse(null);
    }  
    
    public List<Organizacion> getBy(Municipio municipio) {
        List<Organizacion> orgRet = new ArrayList<>() ;
        for (Organizacion o : this.dao.getAll()){
            if(o.getUbicacion().getLocaldiad().getMunicipio().getId().equals(municipio.getId())){
                    orgRet.add(o);
            }
        }

        return orgRet;
    }

    public List<Organizacion> getBy(Provincia provincia) {
        
        List<Organizacion> orgRet = new ArrayList<>() ;
        for (Organizacion o : this.dao.getAll()){
            if(o.getUbicacion().getLocaldiad().getMunicipio().getProvincia().getId().equals(provincia.getId())){
                    orgRet.add(o);
            }
        }
        
        return orgRet;/*this.dao.getAll().stream()
            .filter(org -> org.getUbicacion().getLocaldiad().getMunicipio().getProvincia().getId().equals(provincia.getId()))
            .collect(Collectors.toList());*/
    }

    public List<Organizacion> getAll() {
        return this.dao.getAll();
    }

    public void saveAll(List<Organizacion> o) {
       this.dao.saveAll(o);
    }

    public Organizacion getByRazonSocial(String razonSocial) {
        return this.dao.getAll().stream()
            .filter(org -> org.getRazonSocial().equals(razonSocial))
            .collect(Collectors.toList()).get(0);
    }

    public Organizacion getById(Integer id) {
        return this.dao.findOne(id);
    }
}
