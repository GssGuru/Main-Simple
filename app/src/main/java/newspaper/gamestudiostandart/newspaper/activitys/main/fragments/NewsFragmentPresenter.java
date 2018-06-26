package newspaper.gamestudiostandart.newspaper.activitys.main.fragments;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.Collections;

import newspaper.gamestudiostandart.newspaper.activitys.main.fragments.models.NewsModel;
import newspaper.gamestudiostandart.newspaper.repository.communication.GetNewsListImplement;
import newspaper.gamestudiostandart.newspaper.repository.communication.GetNewsListInteractor;
import newspaper.gamestudiostandart.newspaper.repository.database.DBHelper;
import newspaper.gamestudiostandart.newspaper.repository.database.DBHelperNewsInteractor;

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
        dbHelperNewsInteractor = DBHelper.getInstance();
    }

    public void getNewsList(String author) {
        getNewsListInteractor.getList(this, author);
    }

    @Override
    public void onFinishedGetList(ArrayList<NewsModel> list, String author) {
        if (this.list != null) {
            if (Collections.singletonList(list).equals(Collections.singletonList(this.list))) {
                getViewState().equalsList();
            } else {
                this.list = list;
                dbHelperNewsInteractor.setTableNews(this, author, this.list);
                getViewState().setListNews(this.list);
            }
        } else {
            this.list = list;
            dbHelperNewsInteractor.setTableNews(this, author, this.list);
            getViewState().setListNews(this.list);
        }
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
    }
}