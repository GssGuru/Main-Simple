package newspaper.gamestudiostandart.newspaper.repository.communication;



import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.activitys.main.fragments.models.NewsModel;

public interface GetNewsListInteractor {

    interface OnFinishedListener {

        void onFinishedGetList(ArrayList<NewsModel> list, String author);
        void onFailedGetList(String message, String author);
    }

    void getList(OnFinishedListener listener, String author);
}
