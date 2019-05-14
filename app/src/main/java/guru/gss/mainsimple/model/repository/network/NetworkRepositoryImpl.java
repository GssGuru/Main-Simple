package guru.gss.mainsimple.model.repository.network;

import java.util.Objects;

import guru.gss.mainsimple.model.interactors.news.interfaces.OnFinishedListener;
import guru.gss.mainsimple.utils.model.NewsApiModel;
import guru.gss.mainsimple.utils.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
ENG: Repository for work with internet request
RU: Repository для работи с Интернет запросами
*/
public class NetworkRepositoryImpl implements NetworkRepository {

    private String KEY = "7c4feddaa4b749a48dfa50252ccde419";

    @Override
    public void getNews(final OnFinishedListener listener, final String author) {
        Call<NewsApiModel> call = RetrofitClient.getInstance().getApiClient().getNewsList(author, "top", KEY);
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
