package dds.tp.carbono.services.huella.calculador.org.commands;

import dds.tp.carbono.entities.huella.HuellaCarbono;

public interface HuellaCommand {
    public HuellaCarbono calcular() throws Exception;
}
