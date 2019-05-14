package guru.gss.mainsimple.model.interactors.news;

import java.util.ArrayList;

import guru.gss.mainsimple.model.interactors.Interactor;
import guru.gss.mainsimple.model.interactors.news.interfaces.OnFinishedListener;
import guru.gss.mainsimple.model.repository.network.NetworkRepository;

/*
ENG: Interactor for entitie News
RU: Интерактор для сущности News
*/
public class NewsInteractor implements Interactor.InteractorNews {

    private NetworkRepository networkRepository;

    public NewsInteractor(NetworkRepository networkRepository) {
        this.networkRepository = networkRepository;
    }

    @Override
    public void getList(String author, OnFinishedListener listener) {
        networkRepository.getNews(listener, author);
    }

}
