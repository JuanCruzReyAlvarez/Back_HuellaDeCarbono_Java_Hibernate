package dds.tp.carbono.entities.huella;



public enum UnidadFE {
    kgCO2eq_kWh,
    kgCO2eq_KM,
    kgCO2eq_M3,
    kgCO2eq_KG,
    kgCO2eq_LT,
    gCO2eq_kWh,
    gCO2eq_KM,
    gCO2eq_M3,
    gCO2eq_KG,
    gCO2eq_LT,
    tnCO2eq_kWh,
    tnCO2eq_KM,
    tnCO2eq_M3,
    tnCO2eq_KG,
    tnCO2eq_LT,;

    @Override
    public String toString() {
        String str = super.toString();
        return str.replace("_", "/");
    }

    public static UnidadFE valueOfStr(String str) {
        return UnidadFE.valueOf(str.replace("/", "_"));
    }
}
