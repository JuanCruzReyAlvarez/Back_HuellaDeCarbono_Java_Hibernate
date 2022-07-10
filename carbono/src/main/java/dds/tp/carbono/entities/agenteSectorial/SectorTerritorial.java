package dds.tp.carbono.entities.agenteSectorial;

import java.util.List;

import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.organization.Organizacion;
import lombok.Getter;
import lombok.Setter;

public abstract class SectorTerritorial {
    @Getter @Setter protected Usuario usuario;
    public abstract List<Organizacion> getOrganizaciones();
}
