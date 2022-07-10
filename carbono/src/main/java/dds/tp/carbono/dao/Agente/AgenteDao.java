package dds.tp.carbono.dao.Agente;

import dds.tp.carbono.agenteSectorial.agente.AgenteSectorial;
import dds.tp.carbono.dao.member.Dao;

public class AgenteDao extends Dao<AgenteSectorial>{
    
    
        private static AgenteDao instance;

        public static AgenteDao getInstance() {
            if (instance == null)
                instance = new AgenteDao();
    
            return instance;
        }

        @Override
        public AgenteSectorial setId(Integer id, AgenteSectorial item) {
            item.setId(id);
            return item;
        }


}
