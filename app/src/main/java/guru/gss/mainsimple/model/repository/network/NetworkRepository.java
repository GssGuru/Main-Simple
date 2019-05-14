package guru.gss.mainsimple.model.repository.network;

import guru.gss.mainsimple.model.interactors.news.interfaces.OnFinishedListener;

/*
ENG: Repository for work with internet request
RU: Repository для работи с Интернет запросами
*/
public interface NetworkRepository {

    void getNews(OnFinishedListener listener, String author);

}
