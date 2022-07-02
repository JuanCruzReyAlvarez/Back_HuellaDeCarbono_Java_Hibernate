package dds.tp.carbono.entities.huella.converterUnidades;

import dds.tp.carbono.entities.huella.HuellaCarbono;

public abstract class UnidadHC {
    
    public void reducir(HuellaCarbono hc) throws Exception {
        hc.setValor(hc.getValor() * 1000);
    }

    public void incrementar(HuellaCarbono hc) throws Exception {
        hc.setValor(hc.getValor() / 1000);
    }

    public abstract boolean esMayor(UnidadHC unidad);
}