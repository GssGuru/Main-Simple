package guru.gss.mainsimple.ui;

import android.view.View;

import com.arellomobile.mvp.MvpAppCompatFragment;

import guru.gss.mainsimple.ui.utils.UiUtilsInteractor;

public class BaseFragment extends MvpAppCompatFragment {

    public void showContentAnimation(UiUtilsInteractor.ContentAnimator interactor, View newView, View oldView) {
        interactor.changeContent(newView, oldView);
    }
}
