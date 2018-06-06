package newspaper.gamestudiostandart.newspaper.fragments;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;

import newspaper.gamestudiostandart.newspaper.AppSetings;
import newspaper.gamestudiostandart.newspaper.model.NewsModel;
import newspaper.gamestudiostandart.newspaper.repository.geffromweb.GetNewsListImplement;
import newspaper.gamestudiostandart.newspaper.repository.geffromweb.GetNewsListInteractor;
import newspaper.gamestudiostandart.newspaper.repository.getfromstorege.DBHelperNews;
import newspaper.gamestudiostandart.newspaper.repository.getfromstorege.DBHelperNewsInteractor;

@InjectViewState
public class NewsFragmentPresenter extends MvpPresenter<NewsFragmentView> implements
        GetNewsListInteractor.OnFinishedListener,
        DBHelperNewsInteractor.SetNewsListener {

    private GetNewsListInteractor getNewsListInteractor;
    private DBHelperNewsInteractor dbHelperNewsInteractor;
    private ArrayList<NewsModel> list;

    public ArrayList<NewsModel> getList() {
        return list;
    }

    NewsFragmentPresenter() {
        this.getNewsListInteractor = new GetNewsListImplement();
        dbHelperNewsInteractor = DBHelperNews.getInstance();
    }

    public void getNewsList(String author) {
        getNewsListInteractor.getList(this, author);
    }

    @Override
    public void onFinishedGetList(ArrayList<NewsModel> list, String author) {
        this.list = list;
        dbHelperNewsInteractor.setTableNews(this, author, this.list);
        getViewState().setListNews(this.list);
    }

    @Override
    public void onFailedGetList(String message, String author) {
        dbHelperNewsInteractor.getTableNews(this, author);
    }

    @Override
    public void getListFromNewsListner(ArrayList<NewsModel> list) {
        this.list = list;
        getViewState().setListNews(this.list);
    }

    @Override
    public void addListToNewsListner(boolean saccess) {
        Log.d(AppSetings.LOGS, getClass().getSimpleName() + " addListToNewsListner - " + saccess);
    }
}