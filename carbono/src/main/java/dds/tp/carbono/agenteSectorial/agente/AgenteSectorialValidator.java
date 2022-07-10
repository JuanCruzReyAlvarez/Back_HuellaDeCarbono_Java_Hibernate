package dds.tp.carbono.agenteSectorial.agente;

public class AgenteSectorialValidator {
    public Boolean validate(AgenteSectorial agente){
        return agente.getSectorGeografico()!= null;
    }
}
