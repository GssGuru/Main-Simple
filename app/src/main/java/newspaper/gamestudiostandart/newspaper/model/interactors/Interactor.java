package newspaper.gamestudiostandart.newspaper.model.interactors;

import newspaper.gamestudiostandart.newspaper.model.interactors.news.interfaces.OnFinishedListener;

public interface Interactor {

    interface InteractorNews {

        void getList(String author, OnFinishedListener listener);
    }
}
