package newspaper.gamestudiostandart.newspaper.repository.communication.retrofit;

import java.util.concurrent.TimeUnit;

import newspaper.gamestudiostandart.newspaper.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://newsapi.org/v1/";

    private static RetrofitClient instance = null;
    private ApiService apiService;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
//                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(initHttpClient())
                .build();
        apiService = retrofit.create(ApiService.class);
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

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            okHttpBuilder.addInterceptor(loggingInterceptor);
        }

        return okHttpBuilder.build();
    }

    public static void recreateRetrofit() {
        instance = null;
    }

    public ApiService getApiService() {
        return apiService;
    }

}
