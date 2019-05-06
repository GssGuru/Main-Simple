package newspaper.gamestudiostandart.newspaper.model.repository.network;

import java.util.Objects;

import newspaper.gamestudiostandart.newspaper.model.interactors.news.interfaces.OnFinishedListener;
import newspaper.gamestudiostandart.newspaper.utils.model.NewsApiModel;
import newspaper.gamestudiostandart.newspaper.utils.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkRepositoryImpl implements NetworkRepository {

    @Override
    public void getNews(final OnFinishedListener listener, final String author, String key) {
        Call<NewsApiModel> call = RetrofitClient.getInstance().getApiClient().getNewsList(author, "top", key);
        call.enqueue(new Callback<NewsApiModel>() {
            @Override
            public void onResponse(Call<NewsApiModel> call, Response<NewsApiModel> response) {
                if (response.body() != null) {
                    listener.onFinishedGetList(Objects.requireNonNull(response.body()).getArticles());
                } else {
                    listener.onFailedGetList(response.message());
                }
            }

            @Override
            public void onFailure(Call<NewsApiModel> call, Throwable t) {
                listener.onFailedGetList(t.toString());
            }
        });
    }
}
