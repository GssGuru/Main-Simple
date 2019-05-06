package newspaper.gamestudiostandart.newspaper.model.repository.network;

import newspaper.gamestudiostandart.newspaper.model.interactors.news.interfaces.OnFinishedListener;

public interface NetworkRepository {

    void getNews(OnFinishedListener listener, String author, String key);

}
