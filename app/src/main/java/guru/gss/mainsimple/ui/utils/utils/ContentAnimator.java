package guru.gss.mainsimple.ui.utils.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import guru.gss.mainsimple.ui.utils.UiUtilsInteractor;

/*
ENG: Utils for work with animation
RU: Utils для работы с анимацией
*/
public class ContentAnimator implements UiUtilsInteractor.ContentAnimator {

    public void changeContent(final View newView, final View oldView) {
        final AlphaAnimation newViewAnimation = new AlphaAnimation(0.0f, 1.0f);
        AlphaAnimation oldViewAnimation = new AlphaAnimation(1.0f, 0.0f);
        newViewAnimation.setDuration(250);
        oldViewAnimation.setDuration(250);
        oldView.startAnimation(oldViewAnimation);
        oldViewAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                oldView.setVisibility(View.GONE);
                newView.setVisibility(View.VISIBLE);
                newView.startAnimation(newViewAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
}
