package dds.tp.carbono.repository.admin;

import dds.tp.carbono.dao.admin.TransportePublicoDao;
import dds.tp.carbono.entities.transport.TransportePublico;

public class TransportePublicoRepository {
    private TransportePublicoDao dao;

    public TransportePublicoRepository() {
        this.dao = TransportePublicoDao.getInstance();
        this.dao.setClazz(TransportePublico.class);
        
    }
    
    public TransportePublico guardar(TransportePublico transporte) {
        return this.dao.save(transporte);
    }

    public boolean existe(TransportePublico transporte) {
        return this.dao.getAll().stream().anyMatch(t -> t.getId().equals(transporte.getId()));
    }

    public TransportePublico actualizarLinea(TransportePublico transporte) {
        int index = this.dao.getAll().indexOf(transporte);
        this.dao.getAll().get(index).setLinea(transporte.getLinea());
        return this.dao.getAll().get(index);
    }

}
