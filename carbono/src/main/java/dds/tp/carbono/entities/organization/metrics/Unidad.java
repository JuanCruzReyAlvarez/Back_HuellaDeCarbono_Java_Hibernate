package dds.tp.carbono.entities.organization.metrics;

public enum Unidad {
    KG,
    LT,
    M3,
    Kwh,
    KM;

    public static Unidad getBy(TipoDeConsumo tipo) throws Exception {
        switch (tipo) {
            case Nafta: return LT; 
            case Electricidad: return Kwh; 
            case Peso: return KG; 
            case Carbon: return KG; 
            case GasNatural: return M3;
            case Diesel: return LT ;
            case Gasoil: return LT;
            case Kerosene: return LT;
            case FuelOil: return LT;
            case CarbonDeLenia: return KG;
            case Lenia: return KG;
            case GNC: return M3;
            case MateriaPrima: return null;
            case Insumos: return null;
            case ProductosVendidos: return null;
            case Residuos: return null;
            case CamionDeCarga: return null;
            case UtilitarioLiviano: return null;
            case Distancia: return KM;

            default: throw new Exception("Tipo de consumo sin unidad");
        }
    }
}
