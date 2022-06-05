package dds.tp.carbono.services.org.metrics.metrics;

public enum Periodicidad {
    ANUAL,
    MENSUAL;

    public static Periodicidad getBy(String nombre) throws Exception {
        if (nombre.equals("ANUAL"))
            return ANUAL;

        if (nombre.equals("MENSUAL"))
            return ANUAL;
            
        throw new Exception("Periodicidad no existente");
    }
}
