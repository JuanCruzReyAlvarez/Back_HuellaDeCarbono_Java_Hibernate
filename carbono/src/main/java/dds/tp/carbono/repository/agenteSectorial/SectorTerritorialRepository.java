package dds.tp.carbono.repository.agenteSectorial;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.dao.agenteSectorial.SectorMunicipalDao;
import dds.tp.carbono.dao.agenteSectorial.SectorProvincialDao;
import dds.tp.carbono.entities.agenteSectorial.SectorMunicipal;
import dds.tp.carbono.entities.agenteSectorial.SectorProvincial;
import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.repository.PuntoGeografico.MunicipioRepository;
import dds.tp.carbono.services.external.dto.Municipio;

public class SectorTerritorialRepository {

    private SectorMunicipalDao sectorMunicipalDao;
    private SectorProvincialDao sectorProvincialDao;


    public SectorTerritorialRepository() {
        this.sectorMunicipalDao = SectorMunicipalDao.getInstance();
        this.sectorProvincialDao = SectorProvincialDao.getInstance();

        this.sectorMunicipalDao.setClazz(SectorMunicipal.class);
        this.sectorProvincialDao.setClazz(SectorProvincial.class);
    }



    public SectorTerritorial guardar(SectorTerritorial sectorTerritorial) {

        if (sectorTerritorial instanceof SectorMunicipal)
            return this.sectorMunicipalDao.save((SectorMunicipal)sectorTerritorial);
        else if (sectorTerritorial instanceof SectorProvincial)
            return this.sectorProvincialDao.save((SectorProvincial)sectorTerritorial);

        return null;
    }

    public SectorTerritorial getBy(Usuario usuario) {

        SectorTerritorial sector = this.sectorProvincialDao.getAll().stream()
            .filter(x -> x.getUsuario().equals(usuario)).findFirst().orElse(null);

        if (sector == null)
            sector = this.sectorMunicipalDao.getAll().stream()
                .filter(x -> x.getUsuario().equals(usuario)).findFirst().orElse(null);

        return sector;
    }

    public SectorTerritorial getByUsuarioId(Integer id) {

        SectorTerritorial sector = this.sectorProvincialDao.getAll().stream()
            .filter(x -> x.getUsuario().getId().equals(id)).findFirst().orElse(null);

        if (sector == null)
            sector = this.sectorMunicipalDao.getAll().stream()
                .filter(x -> x.getUsuario().getId().equals(id)).findFirst().orElse(null);

        return sector;
    }

    public SectorProvincial getSectorProvincialByUsuarioId(Integer id) {
        return this.sectorProvincialDao.getAll().stream()
            .filter(x -> x.getUsuario().getId().equals(id)).findFirst().orElse(null);
    }



    public SectorTerritorial getById(Integer id) {

        SectorTerritorial sector = this.sectorProvincialDao.findOne(id);
         
       if(sector == null) 
       return this.sectorMunicipalDao.findOne(id);
       else
       return sector;
    }



    public List<SectorMunicipal> getSectorMuniBySectorProvincial(Integer idSectorProvincial) {

        SectorProvincial sectorP = this.sectorProvincialDao.getById(idSectorProvincial);
        MunicipioRepository muniRepo = new MunicipioRepository();
        List<Municipio> municipios = muniRepo.getAll().stream().
                                    filter(m -> m.getProvincia().getId().equals(sectorP.getProvincia().getId()))
                                    .collect(Collectors.toList());
        List<SectorMunicipal> sectoresM = new  ArrayList<SectorMunicipal>();
        List<SectorMunicipal> sectoresMfiltrados = new  ArrayList<SectorMunicipal>();
        sectoresM = this.sectorMunicipalDao.getAll();

        for (Municipio m: municipios){

            for (SectorMunicipal sm: sectoresM){
                if(sm.getMunicipio().getId().equals(m.getId()))
                sectoresMfiltrados.add(sm);

            }
        }               
        
        return sectoresMfiltrados;
    }



    public SectorTerritorial getByIdUser(Integer idUser) {
        
        SectorTerritorial sector = this.sectorProvincialDao.getAll().stream()
        .filter(x -> x.getUsuario().getId().equals(idUser)).findFirst().orElse(null);

        if (sector == null)
        sector = this.sectorMunicipalDao.getAll().stream()
            .filter(x -> x.getUsuario().getId().equals(idUser)).findFirst().orElse(null);

         return sector;
    }
}