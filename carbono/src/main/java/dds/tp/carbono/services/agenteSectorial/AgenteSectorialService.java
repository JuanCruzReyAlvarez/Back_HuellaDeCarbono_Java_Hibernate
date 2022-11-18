package dds.tp.carbono.services.agenteSectorial;

import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.repository.agenteSectorial.SectorTerritorialRepository;
import dds.tp.carbono.services.huella.calculador.agenteSectorial.CalculadorHuellaSectorTerritorial;

public class AgenteSectorialService {
    
    private SectorTerritorialRepository repo;

    public AgenteSectorialService() {
        this.repo = new SectorTerritorialRepository();
    }



    public HuellaCarbono calcularHuella(Usuario usuario, PeriodoDeImputacion periodo) throws Exception {
        SectorTerritorial sector = repo.getBy(usuario);

        if (sector == null)
            throw new Exception("Agente Sectorial no tiene asignado un sector territorial");
            
        return new CalculadorHuellaSectorTerritorial(sector, periodo).calcular();
    }

    public SectorTerritorial getSectorById(Integer id){
            return repo.getByIdUser(id);
    }




    

}
