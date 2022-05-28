package dds.tp.carbono.services.external.geo;

import java.util.List;

import dds.tp.carbono.services.external.dto.Pais;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PaisService {

    @GET("/api/paises")
    Call<List<Pais>> get(@Query("offset") Integer offset);
    
}
