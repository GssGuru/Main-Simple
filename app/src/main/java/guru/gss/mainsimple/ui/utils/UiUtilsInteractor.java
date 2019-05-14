package guru.gss.mainsimple.ui.utils;

import android.view.View;

/*
ENG: Interactor for work with Utils
RU: Interactor для работи с Utils
*/
public interface UiUtilsInteractor {

    interface ContentAnimator{
        void changeContent(View newView, View oldView);
    }
}
