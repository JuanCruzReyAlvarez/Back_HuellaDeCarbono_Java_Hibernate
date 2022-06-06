package dds.tp.carbono.services.admin;

import dds.tp.carbono.entities.transport.TransportePublico;
import dds.tp.carbono.repository.admin.TransportePublicoRepository;

public class CreadorLineaTransportePublico {
    
    private TransportePublicoRepository repository;

    public CreadorLineaTransportePublico() {
        this.repository = new TransportePublicoRepository();
    }

    public TransportePublico crearOActualizar(TransportePublico transportePublico) {
        if (this.repository.existe(transportePublico))
            return this.repository.actualizarLinea(transportePublico);

        return this.repository.guardar(transportePublico);
    }
}
