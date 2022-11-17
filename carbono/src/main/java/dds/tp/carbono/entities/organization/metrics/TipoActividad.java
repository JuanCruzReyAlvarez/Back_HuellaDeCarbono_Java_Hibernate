package dds.tp.carbono.entities.organization.metrics;

import dds.tp.carbono.utils.FormatString;

public enum TipoActividad {
    Combustion_Fija,
    Combustion_Movil,
    Electricidad_Adquirida_Consumida,
    Logistica_De_Productos_Servicios,
    Trayecto_Miembros;

    public static TipoActividad getBy(String nombre) throws Exception {

        System.out.println(nombre);
        System.out.println(formatNombre(nombre));
        switch (formatNombre(nombre)) {
            
            case "combustionfija" : return Combustion_Fija;
            case "combustionmovil" : return Combustion_Movil;
            case "electricidadadquiridayconsumida" : return Electricidad_Adquirida_Consumida;
            case "logisticadeproductosyservicios" : return Logistica_De_Productos_Servicios; 
            case "trayectomiembros" : return Trayecto_Miembros; 
                
            default: 
                throw new Exception("Actividad no existente");
        }
   }

   


   @Override
   public String toString() {
        String str = super.toString();
        return str.replaceAll("_", " ");
   }

    private static String formatNombre(String nombre) {
        nombre = FormatString.toLower(nombre);
        nombre = FormatString.sinEspacios(nombre);
        nombre = FormatString.sinTildes(nombre);

        return nombre;
    }
}

