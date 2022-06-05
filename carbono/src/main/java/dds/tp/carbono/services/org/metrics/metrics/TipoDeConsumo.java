package dds.tp.carbono.services.org.metrics.metrics;

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

// agregar los if de los tipos de consumo faltantes
    public static TipoDeConsumo getBy(String nombre) throws Exception{
        if (nombre.equals("Nafta"))
          return Nafta;

        if (nombre.equals("Electricidad"))
          return Electricidad;
        
        if (nombre.equals("Peso"))
          return Peso;

        if (nombre.equals("Carbon"))
          return Carbon;

        if (nombre.equals("Distancia"))
          return Distancia;

          throw new Exception("Tipo de consumo no existente");
   }
}
