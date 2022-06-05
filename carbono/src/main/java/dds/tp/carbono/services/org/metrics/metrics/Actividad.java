package dds.tp.carbono.services.org.metrics.metrics;

public enum Actividad {
    CombustionFija,
    CombustionMovil,
    ElectricidadAdquiridaConsumida,
    LogisticaDeProductosServicios;


    public static Actividad getBy(String nombre) throws Exception{
        if (nombre.equals("Combustión Fija"))
          return CombustionFija;

        if (nombre.equals("Combustión Movil"))
          return CombustionMovil;
        
        if (nombre.equals("Electricidad adquirida y consumida"))
          return ElectricidadAdquiridaConsumida;

        if (nombre.equals("Lógistica de productos servicios"))
          return LogisticaDeProductosServicios;

          throw new Exception("Actividad no existente");
   }
}

