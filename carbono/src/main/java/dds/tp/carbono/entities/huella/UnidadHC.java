package dds.tp.carbono.entities.huella;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;




public abstract class UnidadHC {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    public abstract String nombre();

    public void reducir(HuellaCarbono hc) throws Exception {
        hc.setValor(hc.getValor() * 1000);
    }

    public void incrementar(HuellaCarbono hc) throws Exception {
        hc.setValor(hc.getValor() / 1000);
    }

    public abstract boolean esMayor(UnidadHC unidad);
}
