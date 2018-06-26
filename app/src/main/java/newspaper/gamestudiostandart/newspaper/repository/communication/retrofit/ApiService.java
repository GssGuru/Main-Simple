package newspaper.gamestudiostandart.newspaper.repository.communication.retrofit;

import newspaper.gamestudiostandart.newspaper.activitys.main.fragments.models.NewsApiModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("articles")
    Call<NewsApiModel> getNewsList(@Query("source") String source, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);

}
