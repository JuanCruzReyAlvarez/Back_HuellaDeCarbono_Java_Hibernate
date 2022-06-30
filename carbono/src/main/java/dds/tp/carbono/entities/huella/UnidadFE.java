package dds.tp.carbono.entities.huella;

public enum UnidadFE {
    kgCO2eq_kWh,
    kgCO2eq_KM,
    kgCO2eq_M3,
    kgCO2eq_KG,
    kgCO2eq_LT,;

    @Override
    public String toString() {
        String str = super.toString();
        return str.replace("_", "/");
    }

    public static UnidadFE valueOfStr(String str) {
        return UnidadFE.valueOf(str.replace("/", "_"));
    }
}
