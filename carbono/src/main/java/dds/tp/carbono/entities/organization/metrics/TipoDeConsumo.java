package dds.tp.carbono.entities.organization.metrics;

import dds.tp.carbono.entities.organization.metrics.logistica.CategoriaLogistica;
import dds.tp.carbono.entities.organization.metrics.logistica.TransporteLogistica;
import dds.tp.carbono.utils.FormatString;

public enum TipoDeConsumo {
    Nafta, 
    Electricidad, 
    Carbon, 
    GasNatural,
    Diesel,
    Gasoil,
    Kerosene,
    FuelOil,
    CarbonDeLenia,
    Lenia,
    GNC,
    //logistica
    CamionDeCargaMateriaPrima,
    CamionDeCargaInsumos,
    CamionDeCargaProductosVendidos,
    CamionDeCargaResiduos,
    UtilitarioLivianoMateriaPrima,
    UtilitarioLivianoInsumos,
    UtilitarioLivianoProductosVendidos,
    UtilitarioLivianoResiduos;

    public static TipoDeConsumo getBy(String nombre) throws Exception {
        switch (formatNombre(nombre)) {

            case "nafta": return Nafta;
            case "electricidad": return Electricidad;
            case "carbon": return Carbon;
            case "gasNatural": return GasNatural;
            case "diesel": return Diesel;
            case "gasoil": return Gasoil;
            case "kerosene": return Kerosene;
            case "fuelOil": return FuelOil;
            case "carbondelenia": return CarbonDeLenia;
            case "lenia": return Lenia;
            case "gnc": return GNC;
        
            default: 
                throw new Exception("Tipo de consumo no existente");
        }
   }
   public static TipoDeConsumo getByDTO(String nombre)  {
    switch (nombre) {

        case "NAFTA": 
            return Nafta;
        case "ELECTRICIDAD": 
            return Electricidad;
        case "DIESEL": 
            return Diesel;
        case "GNC": 
            return GNC;
        default: 
            System.out.println("Tipo de consumo proveniente de react no existente");
    }
    return null;
}

   public static TipoDeConsumo getBy(TransporteLogistica transporte, CategoriaLogistica categoria) throws Exception {
        if (transporte.equals(TransporteLogistica.camion_de_carga))
            switch (categoria) {
                case materia_prima: return CamionDeCargaMateriaPrima;
                case insumos: return CamionDeCargaInsumos;
                case productos_vendidos: return CamionDeCargaProductosVendidos;
                case residuos: return CamionDeCargaResiduos;
            }
        else if (transporte.equals(TransporteLogistica.utilitario_liviano)) 
            switch (categoria) {
                case materia_prima: return UtilitarioLivianoMateriaPrima;
                case insumos: return UtilitarioLivianoInsumos;
                case productos_vendidos: return UtilitarioLivianoProductosVendidos;
                case residuos: return UtilitarioLivianoResiduos;
            }

        throw new Exception("Tipo de consumo no existente");
    }

    private static String formatNombre(String nombre) {
        nombre = FormatString.sinEspacios(nombre);
        nombre = FormatString.toLower(nombre);
        nombre = FormatString.sinTildes(nombre);

        return nombre;
    }
}
