package dds.tp.carbono.repository.organization;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;

public class MetricaOrganizacionDao extends Dao<MetricaOrganizacion> {

    private static MetricaOrganizacionDao instance;

    public static MetricaOrganizacionDao getInstance() {
        if (instance == null)
            instance = new MetricaOrganizacionDao();

        return instance;
    }
 
}
