package newspaper.gamestudiostandart.newspaper.fragments;

import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.model.NewsModel;

public interface NewsFragmentView extends MvpView {

    void setListNews(ArrayList<NewsModel> list);
    void someList();
    void setError();
}
