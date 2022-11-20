/* 
package dds.tp.carbono.calculadorHC;

import org.junit.Assert;
import org.junit.Test;

import dds.tp.carbono.entities.huella.GramoUnidadHC;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.huella.KilogramoUnidadHC;


public class HuellaCarbonoSumaTest {
    
    @Test
    public void sumarDosHuellas() throws Exception {

        HuellaCarbono h1 = new HuellaCarbono();
        h1.setUnidad(new GramoUnidadHC());
        h1.setValor(Double.valueOf(500));

        HuellaCarbono h2 = new HuellaCarbono();
        h2.setUnidad(new KilogramoUnidadHC());
        h2.setValor(Double.valueOf(0.5));

        HuellaCarbono h3 = h1.suma(h2);

        Assert.assertEquals(Double.valueOf(1000), h3.getValor());
        Assert.assertTrue(h3.getUnidad() instanceof GramoUnidadHC);
    }
}
*/