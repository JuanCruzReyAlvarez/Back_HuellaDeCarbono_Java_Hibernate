package dds.tp.carbono.dao.org;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.services.reportes.ReportOrganizacion;

public class ReportOrganizacionDao extends Dao<ReportOrganizacion>{
    
    private static ReportOrganizacionDao instance;

    public static ReportOrganizacionDao getInstance() {
        if (instance == null)
            instance = new ReportOrganizacionDao();

        return instance;
    }

}
