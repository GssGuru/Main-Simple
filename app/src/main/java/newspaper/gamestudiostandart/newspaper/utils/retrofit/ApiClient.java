package newspaper.gamestudiostandart.newspaper.utils.retrofit;

import newspaper.gamestudiostandart.newspaper.utils.model.NewsApiModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("articles")
    Call<NewsApiModel> getNewsList(@Query("source") String source, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);

}
