package newspaper.gamestudiostandart.newspaper.repository.communication.newslist;



import newspaper.gamestudiostandart.newspaper.repository.communication.newslist.interfaces.OnFinishedListener;

public interface GetNewsListInteractor {
    void getList(OnFinishedListener listener, String author);
}
