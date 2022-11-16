package dds.tp.carbono.entities.transport;

public enum TipoVehiculoParticular {
    AUTO,
    MOTO,
    CAMIONETA;

    public static TipoVehiculoParticular getByDTO(String nombre)  {
        switch (nombre) {
    
            case "AUTO": 
                return AUTO;
            case "MOTO": 
                return MOTO;
            case "CAMIONETA": 
                return CAMIONETA;
            default: 
                System.out.println("Tipo de transporte publico proveniente de react no existente");
        }
        return null;
    }
}
