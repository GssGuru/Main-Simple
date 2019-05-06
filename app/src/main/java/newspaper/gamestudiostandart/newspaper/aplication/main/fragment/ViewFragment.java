package newspaper.gamestudiostandart.newspaper.aplication.main.fragment;

import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.utils.model.NewsModel;

public interface ViewFragment extends MvpView {

    void setListNews(ArrayList<NewsModel> list);
    void setEmptyList();
    void setError();
}
