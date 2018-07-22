package newspaper.gamestudiostandart.newspaper.repository.communication;



import newspaper.gamestudiostandart.newspaper.repository.communication.interfaces.OnFinishedListener;

public interface GetNewsListInteractor {
    void getList(OnFinishedListener listener, String author);
}
