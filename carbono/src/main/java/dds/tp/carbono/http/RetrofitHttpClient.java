package dds.tp.carbono.http;

import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.OkHttpClient.Builder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHttpClient {
    private static final String TOKEN = "Bearer A38jHYCCd3AJsmW3Yw7TMWQ08WCZTWrTt72YFbTKCwA=";
    private static final String urlApi = "https://ddstpa.com.ar/api/";

    @Getter private Retrofit retrofit;

    public RetrofitHttpClient() {
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(urlApi);
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.client(this.getHttpClient());
        retrofit = builder.build();
    }

    private OkHttpClient getHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.interceptors().clear();
        httpClient = this.addAuthorizationHeader(httpClient);
        return httpClient.build();
    }

    private Builder addAuthorizationHeader(Builder httpClient) {
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder().header("Authorization", TOKEN).build();
            return chain.proceed(request);
        });

        return httpClient;
    }
}
