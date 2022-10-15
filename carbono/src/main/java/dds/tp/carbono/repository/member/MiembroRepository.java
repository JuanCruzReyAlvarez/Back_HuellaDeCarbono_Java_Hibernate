package dds.tp.carbono.repository.member;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.dao.org.MiembroDao;
import dds.tp.carbono.dao.org.SolicitudVinculacionDao;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.organization.EstadoSolicitudVinculacion;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;

public class MiembroRepository {
    
    private SolicitudVinculacionDao soliciturVinculacionDao;
    private MiembroDao miembroDao;

    public MiembroRepository() {
        this.soliciturVinculacionDao = SolicitudVinculacionDao.getInstance();
        this.soliciturVinculacionDao.setClazz(SolicitudVinculacion.class);
    }

    public List<Miembro> getBy(Organizacion org) {
        List<Miembro> miembros = new ArrayList<Miembro>();
        
        org.getSectores().forEach(sector -> {
            miembros.addAll(this.soliciturVinculacionDao.getAll().stream()
            .filter(sol -> sol.getEstado().equals(EstadoSolicitudVinculacion.ACEPTADO) && sol.getSector().equals(sector))
            .map(sol -> sol.getMiembro()).collect(Collectors.toList()));
        });

        return miembros;
    }

    public List<Miembro> getBySector(Sector sector) {

        List<Miembro> miembros = new ArrayList<Miembro>();
        
        miembros.addAll(this.soliciturVinculacionDao.getAll().stream()
            .filter(sol -> sol.getEstado().equals(EstadoSolicitudVinculacion.ACEPTADO) && sol.getSector().equals(sector))
            .map(sol -> sol.getMiembro()).collect(Collectors.toList()));
        
        return null;
    }

    public Miembro guardar(Miembro miembro) {
        return this.miembroDao.save(miembro);
    }
}
