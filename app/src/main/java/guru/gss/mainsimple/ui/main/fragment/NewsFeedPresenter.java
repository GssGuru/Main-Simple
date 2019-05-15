package guru.gss.mainsimple.ui.main.fragment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;

import guru.gss.mainsimple.model.interactors.news.NewsInteractor;
import guru.gss.mainsimple.model.interactors.news.interfaces.OnFinishedListener;
import guru.gss.mainsimple.utils.model.NewsModel;

/*
ENG: Presenter for View in which we store all dynamic data and working with the entitie Interactors
RU: Presenter для View в котором мы храним все динамические данные и работаем с Interactors сущности
*/
@InjectViewState
public class NewsFeedPresenter extends MvpPresenter<NewsFeedFragmentVew> {

    private NewsInteractor newsInteractor;
    private ArrayList<NewsModel> list;

    NewsFeedPresenter(NewsInteractor newsInteractor) {
        this.newsInteractor = newsInteractor;
    }

    public void getNewsList(String author) {
        if (list != null) {
            getViewState().setListNews(list);
        } else {
            newsInteractor.getList(author, new OnFinishedListener() {
                @Override
                public void onFailedGetList(String message) {
                    getViewState().setError();
                }

                @Override
                public void onFinishedGetList(ArrayList<NewsModel> listNews) {
                    if (listNews != null && listNews.size() != 0) {
                        list = listNews;
                        getViewState().setListNews(list);
                    } else {
                        getViewState().setEmptyList();
                    }
                }
            });
        }
    }
}