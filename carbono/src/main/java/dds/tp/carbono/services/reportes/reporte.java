package dds.tp.carbono.services.reportes;

import java.time.LocalDate;

import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.huella.BuscadorFactorEmision;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import lombok.Getter;
import lombok.Setter;

public abstract class reporte {

    @Getter @Setter private Integer id;

    @Getter @Setter private LocalDate fechaGeneracion;

    @Getter @Setter private SectorTerritorial sectorTerritorial;
    
    @Getter @Setter private PeriodoDeImputacion periodoDeImputacion;
    
    @Getter @Setter private HuellaCarbono huellaCarbono;

    @Getter @Setter private BuscadorFactorEmision buscador;
    
    public abstract HuellaCarbono obtenerHuellaTotal() throws Exception;
}
