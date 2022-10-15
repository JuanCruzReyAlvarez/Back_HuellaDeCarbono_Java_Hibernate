package dds.tp.carbono.services.external.geoInfo;

import java.util.List;

import dds.tp.carbono.services.external.dto.Municipio;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MunicipioServiceGeoInfo {

    @GET("/api/municipios")
    Call<List<Municipio>> get(@Query("provinciaId") Integer id, @Query("offset") Integer off);
    
}
