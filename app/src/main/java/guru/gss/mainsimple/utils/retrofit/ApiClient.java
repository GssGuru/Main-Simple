package guru.gss.mainsimple.utils.retrofit;

import guru.gss.mainsimple.utils.model.NewsApiModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
ENG: Interface Api with methods for internet request
RU: Interface Api с методами для интернет запроса
*/
public interface ApiClient {

    @GET("articles")
    Call<NewsApiModel> getNewsList(@Query("source") String source, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);

}
