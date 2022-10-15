package dds.tp.carbono.services.ubicacion;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.http.RetrofitHttpClient;
import dds.tp.carbono.services.external.dto.Localidad;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class UbicacionesServicioExterno implements UbicacionesService {

    private static final Integer OFFSET = 1;
    private static final Integer ID_PAIS_ARGENTINA = 9;

    private ServicioExterno svcExterno;

    public UbicacionesServicioExterno() {
        RetrofitHttpClient http = new RetrofitHttpClient();
        this.svcExterno = http.getRetrofit().create(ServicioExterno.class);
    }
    
    @Override
    public List<Localidad> listadoDeLocalidades(Municipio municipio) throws Exception {
        Response<List<Localidad>> response = svcExterno.localidadesByMunicipio(OFFSET, municipio.getId()).execute();        
        return isSuccessful(response) ? response.body() : new ArrayList<Localidad>();
    }

    @Override
    public List<Provincia> listadoDeProvincias() throws Exception {
        Response<List<Provincia>> response = svcExterno.provinciasAll(OFFSET, ID_PAIS_ARGENTINA).execute();        
        return isSuccessful(response) ? response.body() : new ArrayList<Provincia>();
    }

    @Override
    public List<Municipio> listadoDeMunicipios(Provincia provincia) throws Exception {
        Response<List<Municipio>> response = svcExterno.municipiosByProvincia(OFFSET, provincia.getId()).execute();        
        return isSuccessful(response) ? response.body() : new ArrayList<Municipio>();
    }
    
    private boolean isSuccessful(Response<?> response) throws Exception  {
        int code = response.code();
        
        if (code >= 200 && code < 300)
            return true;
        else if (code == 401 || code == 403)
            throw new Exception("No tenes permiso. Revisar El token");
        
        return false;
    }

    private interface ServicioExterno {
        @GET("localidades")
        Call<List<Localidad>>localidadesByMunicipio(@Query("offset") Integer offset, @Query("municipioId") Integer municipioId);

        @GET("localidades")
        Call<List<Localidad>>localidadesAll(@Query("offset") Integer offset, @Query("paisId") Integer paisId);

        @GET("provincias")
        Call<List<Provincia>>provinciasAll(@Query("offset") Integer offset, @Query("paisId") Integer paisId);
    
        @GET("municipios")
        Call<List<Municipio>>municipiosByProvincia(@Query("offset") Integer offset, @Query("provinciaId") Integer provinciaId);

        @GET("municipios")
        Call<List<Municipio>>municipiosAll(@Query("offset") Integer offset, @Query("paisId") Integer paisId);
    }

    @Override
    public List<Municipio> listadoDeMunicipios() throws Exception {
        Response <List<Municipio>> response = svcExterno.municipiosAll(OFFSET, ID_PAIS_ARGENTINA).execute();        
        return isSuccessful(response) ? response.body() : new ArrayList<Municipio>();
    }
    @Override
    public List<Localidad> listadoDeLocalidades() throws Exception {
        Response <List<Localidad>> response = svcExterno.localidadesAll(OFFSET, ID_PAIS_ARGENTINA).execute();        
        return isSuccessful(response) ? response.body() : new ArrayList<Localidad>();
    }


}
