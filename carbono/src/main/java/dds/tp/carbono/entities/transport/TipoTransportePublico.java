package dds.tp.carbono.entities.transport;

public enum TipoTransportePublico {
    COLECTIVO,
    TREN,
    SUBTE;

    public static TipoTransportePublico getByDTO(String nombre)  {
        switch (nombre) {
    
            case "COLECTIVO": 
                return COLECTIVO;
            case "TREN": 
                return TREN;
            case "SUBTE": 
                return SUBTE;
            default: 
                System.out.println("Tipo de transporte publico proveniente de react no existente");
        }
        return null;
    }
}
