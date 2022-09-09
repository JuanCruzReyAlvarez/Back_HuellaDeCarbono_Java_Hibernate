package dds.tp.carbono.entities.huella;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import dds.tp.carbono.conveters.UnidadHcConverter;
import lombok.Getter;
import lombok.Setter;




@Entity
@Table(name="HuellaCarbono")
public class HuellaCarbono {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Column
    @Getter @Setter private Double valor;
    
    @Convert(converter = UnidadHcConverter.class )
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
