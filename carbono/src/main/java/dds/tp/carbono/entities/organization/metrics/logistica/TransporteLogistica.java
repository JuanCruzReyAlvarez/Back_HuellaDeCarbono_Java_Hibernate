package dds.tp.carbono.entities.organization.metrics.logistica;

import dds.tp.carbono.utils.FormatString;

public enum TransporteLogistica {
    camion_de_carga,
    utilitario_liviano;

    public static TransporteLogistica getBy(String nombre) throws Exception {

        switch (formatNombre(nombre)) {
            case "camiondecarga" : return camion_de_carga;
            case "utilitarioliviano" : return utilitario_liviano;
            default: throw new Exception("Transporte no existente");
        }
   }

    private static String formatNombre(String nombre) {
        nombre = FormatString.toLower(nombre);
        nombre = FormatString.sinEspacios(nombre);
        nombre = FormatString.sinTildes(nombre);

        return nombre;
    }
}
