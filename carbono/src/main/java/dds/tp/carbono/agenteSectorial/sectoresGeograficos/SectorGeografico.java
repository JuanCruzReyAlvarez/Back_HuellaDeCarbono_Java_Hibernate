package dds.tp.carbono.agenteSectorial.sectoresGeograficos;

import java.util.List;

import dds.tp.carbono.dao.member.OrganizacionDao;
import dds.tp.carbono.entities.organization.Organizacion;

public abstract class SectorGeografico {
    protected OrganizacionDao dao;

    public abstract List<Organizacion> getOrganizaciones();
    
}
