package dds.tp.carbono.conveters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import dds.tp.carbono.entities.huella.GramoUnidadHC;
import dds.tp.carbono.entities.huella.KilogramoUnidadHC;
import dds.tp.carbono.entities.huella.ToneladaUnidadHC;
import dds.tp.carbono.entities.huella.UnidadHC;



@Converter(autoApply = true)
public class UnidadHcConverter implements AttributeConverter<UnidadHC, String> {

    @Override
    public String convertToDatabaseColumn(UnidadHC unidadHC) {
        String unidad = null;
        switch (unidadHC.nombre()) {
            case "KG": unidad = "KG";
                break;
            case "TN": unidad = "TN";
                break;
            case "GR": unidad = "GR";
                break;
                
            default: unidad = null;
        }
        return unidad;
    }

    @Override
    public UnidadHC convertToEntityAttribute(String unidad) {
        if(unidad == null)
            return null;
        UnidadHC u = null;
        switch (unidad) {
            case "KG": u = new KilogramoUnidadHC();
                break;
            case "GR": u = new GramoUnidadHC();
                break;
            case "TN": u = new ToneladaUnidadHC();
                break;
            default: throw new IllegalArgumentException(u + " no se puede convertir en unidadHC");
        }
        return u;
    }
}
