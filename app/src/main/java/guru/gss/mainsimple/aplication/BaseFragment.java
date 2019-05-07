package guru.gss.mainsimple.aplication;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.arellomobile.mvp.MvpAppCompatFragment;

public class BaseFragment extends MvpAppCompatFragment {

    public void showContentAnimation(final View newView, final View oldView) {
        final AlphaAnimation newViewAnimation = new AlphaAnimation(0.0f, 1.0f);
        AlphaAnimation oldViewAnimation = new AlphaAnimation(1.0f, 0.0f);
        newViewAnimation.setDuration(250);
        oldViewAnimation.setDuration(250);
        oldView.startAnimation(oldViewAnimation);
        oldViewAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                oldView.setVisibility(View.GONE);
                newView.setVisibility(View.VISIBLE);
                newView.startAnimation(newViewAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }

}
