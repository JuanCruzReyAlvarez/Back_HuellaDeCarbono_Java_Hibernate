package dds.tp.carbono.repository.organization;

import java.util.List;

import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;

public class MetricaOrganizacionRepository {

    private MetricaOrganizacionDao dao; 

    public MetricaOrganizacionRepository() {
        this.dao = MetricaOrganizacionDao.getInstance();
        this.dao.setClazz(MetricaOrganizacion.class);
    }

    
    public void saveAll(List<MetricaOrganizacion> metricas, Integer idOrg) {

       for(MetricaOrganizacion metrica : metricas){
        metrica.setId(idOrg);
       }
            
        this.dao.saveAll(metricas);
    }
}