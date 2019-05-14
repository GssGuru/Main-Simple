package guru.gss.mainsimple.model.interactors;

import guru.gss.mainsimple.model.interactors.news.interfaces.OnFinishedListener;

/*
ENG: Interactor for all entities  in the application
RU: Интерактор для всех сущностей в приложении
*/
public interface Interactor {

    interface InteractorNews {

        void getList(String author, OnFinishedListener listener);
    }
}
