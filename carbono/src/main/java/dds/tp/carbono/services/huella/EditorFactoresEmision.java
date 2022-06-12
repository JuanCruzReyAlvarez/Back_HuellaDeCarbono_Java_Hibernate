package dds.tp.carbono.services.huella;

import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;

public class EditorFactoresEmision {

    FactorEmisionRepository repository;

    public EditorFactoresEmision() {
        this.repository = new FactorEmisionRepository();
    }

    public FactorEmision guardar(FactorEmision fe) throws Exception {
        if (fe.getTipoDeConsumo() == null)
            throw new Exception("FactorEmision debe tener Tipo de Consumo");
        
        return this.repository.guardarOActualizar(fe);
    }

    public FactorEmision actualizarValor(FactorEmision fe) {
        return this.repository.guardarOActualizar(fe);
    }
}