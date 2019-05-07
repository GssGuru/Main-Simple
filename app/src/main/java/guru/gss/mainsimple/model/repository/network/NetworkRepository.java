package guru.gss.mainsimple.model.repository.network;

import guru.gss.mainsimple.model.interactors.news.interfaces.OnFinishedListener;

public interface NetworkRepository {

    void getNews(OnFinishedListener listener, String author, String key);

}
