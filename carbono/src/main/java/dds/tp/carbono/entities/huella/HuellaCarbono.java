package dds.tp.carbono.entities.huella;

import lombok.Getter;
import lombok.Setter;

public class HuellaCarbono {
    @Getter @Setter private Double valor;
    @Getter @Setter private UnidadHC unidad;

    public HuellaCarbono() {
        this.valor = Double.valueOf(0);
        this.unidad = new KilogramoUnidadHC();
    }

    public HuellaCarbono suma(HuellaCarbono hc2) throws Exception {
        HuellaCarbono hc = new HuellaCarbono();

        if (!hc2.getUnidad().equals(this.getUnidad()))
            hc2.convertirUnidad(this.getUnidad());
           
        hc.setValor(this.valor + hc2.getValor());
        hc.setUnidad(this.getUnidad());
        
        return hc;
    }

    private void convertirUnidad(UnidadHC unidadObjetivo) throws Exception {

        if (this.getUnidad().esMayor(unidadObjetivo))
            this.getUnidad().reducir(this);
        else
            this.getUnidad().incrementar(this);

        if (!unidadObjetivo.equals(this.getUnidad()))
            this.convertirUnidad(unidadObjetivo);
    }
}
