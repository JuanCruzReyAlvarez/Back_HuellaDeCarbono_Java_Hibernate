package dds.tp.carbono.entities.organization.metrics;

public enum Periodicidad {
    ANUAL,
    MENSUAL;

    public static Periodicidad getBy(String nombre) throws Exception {
        if (nombre.equals("ANUAL"))
            return ANUAL;

        if (nombre.equals("MENSUAL"))
            return MENSUAL;
            
        throw new Exception("Periodicidad no existente");
    }
}
