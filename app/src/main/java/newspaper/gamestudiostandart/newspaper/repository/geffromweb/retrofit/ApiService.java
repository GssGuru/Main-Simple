package newspaper.gamestudiostandart.newspaper.repository.geffromweb.retrofit;

import newspaper.gamestudiostandart.newspaper.model.NewsApiModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("articles")
    Call<NewsApiModel> getNewsList(@Query("source") String source, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);

}
