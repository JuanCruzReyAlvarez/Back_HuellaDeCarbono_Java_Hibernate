package dds.tp.carbono.services.org.metrics.metrics;

import dds.tp.carbono.utils.FormatString;

public enum TipoDeConsumo {
    Nafta, 
    Electricidad, 
    Peso, 
    Carbon, 
    GasNatural,
    Diesel,
    Gasoil,
    Kerosene,
    FuelOil,
    CarbonDeLenia,
    Lenia,
    GNC,
    MateriaPrima,
    Insumos,
    ProductosVendidos,
    Residuos,
    CamionDeCarga,
    UtilitarioLiviano,
    Distancia; 

    public static TipoDeConsumo getBy(String nombre) throws Exception {
        switch (formatNombre(nombre)) {

            case "nafta": return Nafta;
            case "electricidad": return Electricidad;
            case "peso": return Peso;
            case "carbon": return Carbon;
            case "distancia": return Distancia;
            case "gasNatural": return GasNatural;
            case "diesel": return Diesel;
            case "gasoil": return Gasoil;
            case "kerosene": return Kerosene;
            case "fuelOil": return FuelOil;
            case "carbondelenia": return CarbonDeLenia;
            case "lenia": return Lenia;
            case "gnc": return GNC;
            case "materiaprima": return MateriaPrima;
            case "insumos": return Insumos;
            case "productosvendidos": return ProductosVendidos;
            case "residuos": return Residuos;
            case "camiondecarga": return CamionDeCarga;
            case "utilitarioliviano": return UtilitarioLiviano;
        
            default: throw new Exception("Tipo de consumo no existente");
        }
   }

    private static String formatNombre(String nombre) {
        nombre = FormatString.sinEspacios(nombre);
        nombre = FormatString.toLower(nombre);
        nombre = FormatString.sinTildes(nombre);

        return nombre;
    }
}
