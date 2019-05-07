package guru.gss.mainsimple.model.interactors.news;

import java.util.ArrayList;

import guru.gss.mainsimple.model.interactors.Interactor;
import guru.gss.mainsimple.model.interactors.news.interfaces.OnFinishedListener;
import guru.gss.mainsimple.model.repository.network.NetworkRepository;

public class NewsInteractor implements Interactor.InteractorNews {




    NetworkRepository networkRepository;


    public NewsInteractor(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    public void getList(String author, OnFinishedListener listener) {
        networkRepository.getNews(listener, author, getKey());
    }

    private String getKey() {
        ArrayList<String> listKeys = new ArrayList<>();
        listKeys.add("7c4feddaa4b749a48dfa50252ccde419");
        listKeys.add("d192b8870e094398976a7d54801b99d4");
        listKeys.add("ac0fc119593243c38fd77d1699ea0347");
        listKeys.add("9e5d5f981dd14a6aad17154b3f4c74fd");
        return listKeys.get(1);
    }
}
