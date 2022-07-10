package dds.tp.carbono.entities.huella;

public class ToneladaUnidadHC extends UnidadHC {

    @Override
    public void reducir(HuellaCarbono hc) throws Exception {
        super.reducir(hc);
        hc.setUnidad(new KilogramoUnidadHC());  
    }

    @Override
    public void incrementar(HuellaCarbono hc) throws Exception {
        throw new Exception("Maxima unidad Tonelada");
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ToneladaUnidadHC;
    }

    @Override
    public boolean esMayor(UnidadHC unidad) {
        if (this.equals(unidad))
            return false;

        return true;
    }  
}
