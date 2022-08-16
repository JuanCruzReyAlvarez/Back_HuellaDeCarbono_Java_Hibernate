package dds.tp.carbono.entities.agenteSectorial;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.organization.Organizacion;

public abstract class SectorTerritorial {
    @Getter @Setter Integer id;
    @Getter @Setter protected Usuario usuario;
    @Getter @Setter List<Organizacion> organizaciones;
}
