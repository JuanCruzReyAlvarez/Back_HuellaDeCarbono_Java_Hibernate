package dds.tp.carbono.services.external;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.services.external.dto.GeoInfo;
import dds.tp.carbono.services.external.dto.GeoInfoSearch;
import dds.tp.carbono.services.external.geoInfo.LocalidadServiceGeoInfo;
import dds.tp.carbono.services.external.geoInfo.MunicipioServiceGeoInfo;
import dds.tp.carbono.services.external.geoInfo.ProvinciaServiceGeoInfo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeoInformationService {
   
   private static final String TOKEN = "Bearer EEr2L29kocvFdMU6ALKgnM5TucF5Cei7Srphd9qVKTA=";
   private static final String BASE_URL = "https://ddstpa.com.ar/";
   private static Retrofit.Builder builder = new Retrofit.Builder()
                                                         .baseUrl(BASE_URL)
                                                         .addConverterFactory(GsonConverterFactory.create());
   private static Retrofit retrofit = builder.build();
   private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

   public static <S> S createService(Class<S> serviceClass) {
      httpClient.interceptors().clear();
      httpClient.addInterceptor(chain -> {
         Request original = chain.request();
         Request request = original.newBuilder()
               .header("Authorization", TOKEN)
               .build();
         return chain.proceed(request);
      });

      builder.client(httpClient.build());

      retrofit = builder.build();
      return retrofit.create(serviceClass);
   }

   public List<? extends GeoInfo> search(GeoInfoSearch info) throws IOException {
      switch (info.getType()) {

         // NO TIENE SENTIDO QUE PIDAMOS EL PAIS, NUESTRO SISTEMA POR EL MOMENTO ES NACIONAL.
         //case "pais": return createService(PaisService.class).get(1).execute().body(); 

         case "provincia": return createService(ProvinciaServiceGeoInfo.class).get(info.getId(), 1).execute().body();
         case "municipio": return createService(MunicipioServiceGeoInfo.class).get(info.getId(), 1).execute().body();
         case "localidad": return createService(LocalidadServiceGeoInfo.class).get(info.getId(), 1).execute().body();
         default: return new ArrayList<>();
      }
   }

}
