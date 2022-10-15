package dds.tp.carbono.services.external.geoInfo;

import java.util.List;

import dds.tp.carbono.services.external.dto.Pais;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PaisServiceGeoInfo {

    @GET("/api/paises")
    Call<List<Pais>> get(@Query("offset") Integer offset);
    
}
