package dds.tp.carbono.entities.huella;

public class KilogramoUnidadHC extends UnidadHC {

    @Override
    public void reducir(HuellaCarbono hc) throws Exception {
        super.reducir(hc);
        hc.setUnidad(new GramoUnidadHC());  
    }

    @Override
    public void incrementar(HuellaCarbono hc) throws Exception {
        super.incrementar(hc);
        hc.setUnidad(new ToneladaUnidadHC());  
    } 
    
    @Override
    public boolean equals(Object obj) {
        return obj instanceof KilogramoUnidadHC;
    }

    @Override
    public boolean esMayor(UnidadHC unidad) {
        if (this.equals(unidad))
            return false;

        return unidad instanceof GramoUnidadHC;
    }  
}

