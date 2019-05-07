package guru.gss.mainsimple.aplication.main.fragment;

import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;

import guru.gss.mainsimple.utils.model.NewsModel;

public interface ViewFragment extends MvpView {

    void setListNews(ArrayList<NewsModel> list);
    void setEmptyList();
    void setError();
}
