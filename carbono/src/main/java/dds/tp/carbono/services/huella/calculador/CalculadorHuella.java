package dds.tp.carbono.services.huella.calculador;


import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;

public abstract class CalculadorHuella {
    public HuellaCarbono calcular() throws Exception{return null;}
    public FactorEmisionRepository buscador;
    public PeriodoDeImputacion periodo;


}
