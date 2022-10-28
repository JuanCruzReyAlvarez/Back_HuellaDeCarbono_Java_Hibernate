package dds.tp.carbono.entities.organization;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import lombok.Getter;
import lombok.Setter;

public class IndicadorHCOrganizacion {

    @Getter @Setter private HuellaCarbono unidad;
    @Getter @Setter private Double valor;


}
