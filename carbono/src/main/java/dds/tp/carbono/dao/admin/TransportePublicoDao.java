package dds.tp.carbono.dao.admin;

import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.transport.TransportePublico;

public class TransportePublicoDao extends Dao<TransportePublico> {
    
    private static TransportePublicoDao instance;

    public static TransportePublicoDao getInstance() {
        if (instance == null)
            instance = new TransportePublicoDao();
        return instance;
    }

  
}
