package guru.gss.mainsimple.ui.utils;

import android.view.View;

public interface UiUtilsInteractor {

    interface ContentAnimator{
        void changeContent(View newView, View oldView);
    }
}
