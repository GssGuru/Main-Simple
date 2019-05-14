package guru.gss.mainsimple.ui;

import android.view.View;

import com.arellomobile.mvp.MvpAppCompatFragment;

import guru.gss.mainsimple.ui.utils.UiUtilsInteractor;

/*
ENG: Basic fragment where we write all the functions that can be shared for all fragments.
RU: Базовый фрагмент куда пишем все функции, которые могут быть общими для всех фрагментах
*/
public class BaseFragment extends MvpAppCompatFragment {

    /*
    ENG: Methods for animating the shift of two View
    RU: Методы анимации смены двух View
    */
    public void showContentAnimation(UiUtilsInteractor.ContentAnimator interactor, View newView, View oldView) {
        interactor.changeContent(newView, oldView);
    }
}
