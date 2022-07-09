package dds.tp.carbono.services.organizacion.metrics;

import dds.tp.carbono.entities.organization.metrics.Actividad;
import dds.tp.carbono.entities.organization.metrics.CombustionMóvil;
import dds.tp.carbono.entities.organization.metrics.CombustionFija;
import dds.tp.carbono.entities.organization.metrics.ElectricidadAdquiridaConsumida;
import dds.tp.carbono.entities.organization.metrics.LogisticaDeProductosServicios;
import dds.tp.carbono.entities.organization.metrics.TipoActividad;

public class ActividadFactory {

    public Actividad crearActividad(TipoActividad actividad) {

        if (actividad == TipoActividad.Combustion_Movil){
            return new CombustionMóvil();
        }
        if (actividad == TipoActividad.Combustion_Fija){
            return new CombustionFija();
        }
        if (actividad == TipoActividad.Electricidad_Adquirida_Consumida){
            return new ElectricidadAdquiridaConsumida();
        }
        if (actividad == TipoActividad.Logistica_De_Productos_Servicios){
            return new LogisticaDeProductosServicios();
        }
        return null;
    }

}
