package newspaper.gamestudiostandart.newspaper.activitys.main.fragments;

import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.activitys.main.fragments.models.NewsModel;

public interface NewsFragmentView extends MvpView {

    void setListNews(ArrayList<NewsModel> list);
    void equalsList();
    void setError();
}
