package dds.tp.carbono.entities.organization.metrics;

public enum Periodicidad {
    ANUAL,
    MENSUAL;


public static Periodicidad getBy(String nombre) throws Exception {
    if (nombre.equals("ANUAL"))
        return Periodicidad.ANUAL;

    if (nombre.equals("MENSUAL"))
        return Periodicidad.MENSUAL;
        
    throw new Exception("Periodicidad no existente");
}

}
