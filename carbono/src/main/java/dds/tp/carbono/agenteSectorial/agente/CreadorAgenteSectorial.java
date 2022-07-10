package dds.tp.carbono.agenteSectorial.agente;

import dds.tp.carbono.repository.Agente.AgenteRepository;

public class CreadorAgenteSectorial {
    
    private AgenteRepository repository;

    public void CreadorDeAgente() {
        this.repository = new AgenteRepository();
    }

    public AgenteSectorial crear(AgenteSectorial agente) throws Exception {
        if (!agente.isValid())
            throw new Exception("Agente Invalido");

        return this.repository.guardar(agente);
    }
    
}