package dds.tp.carbono.services.external.geoInfo;

import java.util.List;

import dds.tp.carbono.services.external.dto.Localidad;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LocalidadServiceGeoInfo {
    
    @GET("/api/localidades")
    Call<List<Localidad>> get(@Query("municipioId") Integer id, @Query("offset") Integer off);
    
}
