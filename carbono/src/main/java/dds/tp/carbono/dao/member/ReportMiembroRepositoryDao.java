package dds.tp.carbono.dao.member;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.services.reportes.ReportMiembro;

public class ReportMiembroRepositoryDao extends Dao<ReportMiembro> {
    private static ReportMiembroRepositoryDao instance;

    public static ReportMiembroRepositoryDao getInstance() {
        if (instance == null)
            instance = new ReportMiembroRepositoryDao();

        return instance;
    }
}
