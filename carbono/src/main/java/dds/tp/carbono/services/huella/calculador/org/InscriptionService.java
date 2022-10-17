package dds.tp.carbono.services.huella.calculador.org;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.repository.member.MiembroRepository;
import dds.tp.carbono.repository.organization.SectorRepository;
import dds.tp.carbono.repository.organization.SolicitudVinculacionRepository;

public class InscriptionService {
    private  SolicitudVinculacionRepository repository;
    private SectorRepository sectorRepository;
    private MiembroRepository miembroRepository;

    public InscriptionService() {
        this.repository = new SolicitudVinculacionRepository();
        this.sectorRepository = new SectorRepository();
        this.miembroRepository = new MiembroRepository();
    }

    public SolicitudVinculacion agregar(Integer idMiembro, Integer idSector)  {

        Sector sector = sectorRepository.getById(idSector);
        Miembro miembro = miembroRepository.getById(idMiembro);
        SolicitudVinculacion solicitd = new SolicitudVinculacion(miembro, sector);
        return this.repository.crearSolicitud(solicitd);
    }
}

