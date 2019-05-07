package guru.gss.mainsimple.utils.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://newsapi.org/v1/";

    private static RetrofitClient instance = null;
    private ApiClient apiClient;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
//                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(initHttpClient())
                .build();
        apiClient = retrofit.create(ApiClient.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    private OkHttpClient initHttpClient() {

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        int RESPONSE_TIMEOUT = 120;
        okHttpBuilder.connectTimeout(RESPONSE_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(RESPONSE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(RESPONSE_TIMEOUT, TimeUnit.SECONDS);

        return okHttpBuilder.build();
    }

    public static void recreateRetrofit() {
        instance = null;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

}
