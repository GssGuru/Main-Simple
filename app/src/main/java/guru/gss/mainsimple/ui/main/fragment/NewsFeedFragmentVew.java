package guru.gss.mainsimple.ui.main.fragment;

import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;

import guru.gss.mainsimple.utils.model.NewsModel;

/*
ENG: interface to work with View from Presenter
RU: interface для работы с View из Presenter
*/
public interface NewsFeedFragmentVew extends MvpView {

    void setListNews(ArrayList<NewsModel> list);

    void setEmptyList();

    void setError();
}
