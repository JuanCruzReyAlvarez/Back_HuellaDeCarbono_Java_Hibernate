package dds.tp.carbono.services.huella.calculador.org;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.repository.member.MiembroRepository;
import dds.tp.carbono.services.huella.calculador.org.commands.HuellaCommand;
import dds.tp.carbono.services.huella.calculador.org.commands.HuellaParaMetricasCommand;
import dds.tp.carbono.services.huella.calculador.org.commands.HuellaParaTrayectosCommand;
import dds.tp.carbono.services.huella.calculador.org.filter.TrayectosCompartidosFilter;
import lombok.Getter;
import lombok.Setter;

public class CalculadorHuellaOrganizacion {

    @Getter @Setter private PeriodoDeImputacion periodo;
    @Getter @Setter private Organizacion organizacion;

    List<HuellaCommand> diferentesCalculosParaOrg; 

    public CalculadorHuellaOrganizacion(Organizacion org, PeriodoDeImputacion periodo) {
        this.periodo = periodo;
        this.organizacion = org;
        MiembroRepository repo = new MiembroRepository();
        TrayectosCompartidosFilter trayectosFilter = new TrayectosCompartidosFilter(repo.getBy(org));

        this.diferentesCalculosParaOrg = new ArrayList<HuellaCommand>() {{
            add(new HuellaParaMetricasCommand(org.getMetricas(periodo)));
            add(new HuellaParaTrayectosCommand(trayectosFilter.filtrarCompartidos()));
        }};
    }

    public HuellaCarbono calcula() throws Exception {

        HuellaCarbono huellaCarbono = new HuellaCarbono();

        for (HuellaCommand command : this.diferentesCalculosParaOrg)
            huellaCarbono = huellaCarbono.suma(command.calcular());

        return huellaCarbono;
    }
}
 