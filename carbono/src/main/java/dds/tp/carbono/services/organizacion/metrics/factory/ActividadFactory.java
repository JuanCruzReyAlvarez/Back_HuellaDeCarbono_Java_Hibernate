package dds.tp.carbono.services.organizacion.metrics.factory;

import dds.tp.carbono.entities.organization.metrics.Actividad;
import dds.tp.carbono.entities.organization.metrics.CombustionFija;
import dds.tp.carbono.entities.organization.metrics.CombustionMovil;
import dds.tp.carbono.entities.organization.metrics.Consumo;
import dds.tp.carbono.entities.organization.metrics.ElectricidadAdquiridaConsumida;
import dds.tp.carbono.entities.organization.metrics.TipoActividad;

public class ActividadFactory {

    public static Actividad crearActividad(TipoActividad actividad, Consumo consumo) {

        switch (actividad) {
            case Combustion_Movil: return new CombustionMovil(consumo);
            case Combustion_Fija: return new CombustionFija(consumo);
            case Electricidad_Adquirida_Consumida: return new ElectricidadAdquiridaConsumida(consumo);
            default:
                return null;
        } 
    }
}
