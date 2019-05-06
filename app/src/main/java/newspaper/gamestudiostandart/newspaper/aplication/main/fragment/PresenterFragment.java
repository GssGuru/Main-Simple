package newspaper.gamestudiostandart.newspaper.aplication.main.fragment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.model.interactors.news.NewsInteractor;
import newspaper.gamestudiostandart.newspaper.model.interactors.news.interfaces.OnFinishedListener;
import newspaper.gamestudiostandart.newspaper.utils.model.NewsModel;

@InjectViewState
public class PresenterFragment extends MvpPresenter<ViewFragment> {

    private NewsInteractor newsInteractor;
    private ArrayList<NewsModel> list;

    PresenterFragment(NewsInteractor newsInteractor) {
        this.newsInteractor = newsInteractor;
    }

    public void getNewsList(String author) {
        if (list != null){
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