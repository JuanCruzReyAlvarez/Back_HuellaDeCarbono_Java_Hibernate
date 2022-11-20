package dds.tp.carbono.services.admin;

import dds.tp.carbono.repository.agenteSectorial.SectorTerritorialRepository;
import dds.tp.carbono.repository.member.MiembroRepository;
import dds.tp.carbono.repository.organization.OrganizacionRepository;

public class LogExistService {
    
    public MiembroRepository miembroRepository;
    public OrganizacionRepository organizacionRepository;
    public SectorTerritorialRepository sectorTerritorialRepository;

    public LogExistService() {
        this.miembroRepository = new MiembroRepository();
        this.organizacionRepository = new OrganizacionRepository();
        this.sectorTerritorialRepository = new SectorTerritorialRepository();
    }

    public  boolean miembroExists(Integer userId) {
        return (miembroRepository.getByUserId(userId))!= null;
    }

    public  boolean organizacionExists(Integer userId) {
        return organizacionRepository.getByUser(userId) != null;
    }

    public  boolean sectorExists(Integer userId) {
        return sectorTerritorialRepository.getByIdUser(userId) != null;
    }

}
