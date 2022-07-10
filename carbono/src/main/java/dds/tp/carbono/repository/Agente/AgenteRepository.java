package dds.tp.carbono.repository.Agente;

import dds.tp.carbono.agenteSectorial.agente.AgenteSectorial;
import dds.tp.carbono.dao.Agente.AgenteDao;

public class AgenteRepository {
    
    private AgenteDao dao;

    public AgenteRepository() {
        this.dao = AgenteDao.getInstance();
    }

    public AgenteSectorial guardar(AgenteSectorial agente) {
        return this.dao.save(agente);
    }

 
}