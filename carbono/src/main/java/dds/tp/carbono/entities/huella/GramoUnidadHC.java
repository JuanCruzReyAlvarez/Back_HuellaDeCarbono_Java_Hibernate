package dds.tp.carbono.entities.huella;

public class GramoUnidadHC extends UnidadHC {

    @Override
    public void reducir(HuellaCarbono hc) throws Exception {
        throw new Exception("Gramo es la unidad minima");
    }

    @Override
    public void incrementar(HuellaCarbono hc) throws Exception {
        super.incrementar(hc);
        hc.setUnidad(new KilogramoUnidadHC());  
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof GramoUnidadHC;
    }

    @Override
    public boolean esMayor(UnidadHC unidad) {
        return false;
    }  
}