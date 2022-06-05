package dds.tp.carbono.services.distancia;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.http.RetrofitHttpClient;
import dds.tp.carbono.services.external.dto.Distancia;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class CalculadorDistanciaServicioExterno {
    
    private ServicioExterno svcExterno;
    
    public CalculadorDistanciaServicioExterno() {
        RetrofitHttpClient http = new RetrofitHttpClient();
        this.svcExterno = http.getRetrofit().create(ServicioExterno.class);
    }
   
    public Double calcularDistancia(PuntoGeografico origen, PuntoGeografico destino) throws Exception {
        Response<Distancia> response = this.svcExterno.distancias(
            origen.getIdLocalidad(), origen.getCalle(), origen.getAltura(),
            destino.getIdLocalidad(), destino.getCalle(), destino.getAltura()).execute();

        return this.isSuccessful(response) ? Double.parseDouble(response.body().getValor()) : 0;
    }

    private boolean isSuccessful(Response<?> response) throws Exception {
        int code = response.code();
        
        if (code >= 200 && code < 300)
            return true;
        else if (code == 401 || code == 403)
            throw new Exception("No tenes permiso. Revisar El token");
        
        return false;
    }

    private interface ServicioExterno {
        @GET("distancia")
        Call<Distancia> distancias(@Query("localidadOrigenId") Integer localidadOrigenId,
                                   @Query("calleOrigen") String calleOrigen,
                                   @Query("alturaOrigen") String alturaOrigen,
                                   @Query("localidadDestinoId") Integer localidadDestinoId,
                                   @Query("calleDestino") String calleDestino,
                                   @Query("alturaDestino") String calleDestinalturaDestino);
    }
}