package guru.gss.mainsimple.model.interactors;

import guru.gss.mainsimple.model.interactors.news.interfaces.OnFinishedListener;

public interface Interactor {

    interface InteractorNews {

        void getList(String author, OnFinishedListener listener);
    }
}
