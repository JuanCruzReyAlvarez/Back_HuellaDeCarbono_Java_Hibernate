package dds.tp.carbono.services.external.geo;

import java.util.List;

import dds.tp.carbono.services.external.dto.Provincia;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProvinciaService {

    @GET("/api/provincias")
    Call<List<Provincia>> get(@Query("paisId") Integer paisId, @Query("offset") Integer offset);
    
}
