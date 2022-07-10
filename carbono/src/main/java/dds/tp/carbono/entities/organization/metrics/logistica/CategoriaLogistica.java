package dds.tp.carbono.entities.organization.metrics.logistica;

import dds.tp.carbono.utils.FormatString;

public enum CategoriaLogistica {
    materia_prima,
    insumos, 
    productos_vendidos, 
    residuos;

    public static CategoriaLogistica getBy(String nombre) throws Exception {

        switch (formatNombre(nombre)) {
            case "materiaprima" : return materia_prima;
            case "insumos" : return insumos;
            case "productosvendidos" : return productos_vendidos;
            case "residuos" : return residuos; 
                
            default: throw new Exception("Categoria no existente");
        }
   }

    private static String formatNombre(String nombre) {
        nombre = FormatString.toLower(nombre);
        nombre = FormatString.sinEspacios(nombre);
        nombre = FormatString.sinTildes(nombre);

        return nombre;
    }
}
