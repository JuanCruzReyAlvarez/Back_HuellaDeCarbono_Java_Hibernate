package dds.tp.carbono.services.org.metrics.metrics;

public enum Unidad {
    KG,
    LT,
    M3,
    Kwh,
    KM;

    public static Unidad getBy(TipoDeConsumo tipo) throws Exception {
        switch (tipo) { //agregar todos los tipos de consumo
            case Nafta: return Unidad.KG;
            case Electricidad: return Unidad.KG;
            case Peso: return Unidad.KG;
            case Carbon: return Unidad.KG;
            case Distancia: return Unidad.KG;
                default: throw new Exception();
        }
    }
}
