package dds.tp.carbono.dao.member;

import dds.tp.carbono.entities.member.TrayectoPendiente;

public class TrayectoPendienteDao extends Dao<TrayectoPendiente>{

    private static TrayectoPendienteDao instance;

    public static TrayectoPendienteDao getInstance() {
        if (instance == null)
            instance = new TrayectoPendienteDao();

        return instance;
    }


}
