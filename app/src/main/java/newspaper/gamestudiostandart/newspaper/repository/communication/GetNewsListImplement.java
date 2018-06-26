package newspaper.gamestudiostandart.newspaper.repository.communication;


import java.util.Objects;
import java.util.Random;

import newspaper.gamestudiostandart.newspaper.AppSetings;
import newspaper.gamestudiostandart.newspaper.activitys.main.fragments.models.NewsApiModel;
import newspaper.gamestudiostandart.newspaper.repository.communication.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetNewsListImplement implements GetNewsListInteractor {

    private int mControlerErrorKeys = 0;

    /*
    Recursive method.
    The request can return Null if the number of daily requests by the key is terminated.
    If this happens, we take another key and repeat the request.
    But not more than 5 drinks.
    For this, there is a variable mControlerErrorKeys
    */

    @Override
    public void getList(final OnFinishedListener listener, final String author) {

        Call<NewsApiModel> call = RetrofitClient.getInstance().getApiService().getNewsList(author, "top", getKey());
        call.enqueue(new Callback<NewsApiModel>() {
            @Override
            public void onResponse(Call<NewsApiModel> call, Response<NewsApiModel> response) {
                if (response.body() != null) {
                    listener.onFinishedGetList(Objects.requireNonNull(response.body()).getArticles(), author);
                } else {
                    if (mControlerErrorKeys < 5) {
                        getList(listener, author);
                        mControlerErrorKeys = mControlerErrorKeys + 1;
                    } else {
                        listener.onFailedGetList(response.message(), author);
                    }
                }
            }

            @Override
            public void onFailure(Call<NewsApiModel> call, Throwable t) {
                listener.onFailedGetList(t.toString(), author);
            }
        });
    }

    /*get random key because one key can give only 1.000 request per one day*/
    private String getKey(){
        return AppSetings.listKeys.get((new Random()).nextInt(AppSetings.listKeys.size()));
    }
}
