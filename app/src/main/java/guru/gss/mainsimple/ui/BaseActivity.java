package guru.gss.mainsimple.ui;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import guru.gss.mainsimple.R;
import guru.gss.mainsimple.ui.main.fragment.NewsFeedFragment;

/*
ENG: Basic activity where we write all the functions that can be common to all activate
RU: Базовые activity куда пишем все функции, которые могут быть общими для всех активируют
*/
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    /*
    ENG: The method returns a fragment in accordance with the ID
    RU: Метод возвращает фрагмент в соответствии с ID
    */
    public Fragment getMainFragment(int id) {
        Fragment fragment = null;
        switch (id) {
            case R.id.i_the_washington_post:
                fragment = NewsFeedFragment.newInstance("the-washington-post", getResources().getString(R.string.the_washington_post));
                break;
            case R.id.i_the_new_york_times:
                fragment = NewsFeedFragment.newInstance("the-new-york-times", getResources().getString(R.string.the_new_york_times));
                break;
            case R.id.i_the_telegraph:
                fragment = NewsFeedFragment.newInstance("the-telegraph", getResources().getString(R.string.the_telegraph));
                break;
            case R.id.i_cnn:
                fragment = NewsFeedFragment.newInstance("cnn", getResources().getString(R.string.cnn));
                break;
            case R.id.i_time:
                fragment = NewsFeedFragment.newInstance("time", getResources().getString(R.string.time));
                break;
            case R.id.i_bbc_news:
                fragment = NewsFeedFragment.newInstance("bbc-news", getResources().getString(R.string.bbc_news));
                break;
            case R.id.i_associated_press:
                fragment = NewsFeedFragment.newInstance("associated-press", getResources().getString(R.string.associated_press));
                break;
            case R.id.i_independent:
                fragment = NewsFeedFragment.newInstance("independent", getResources().getString(R.string.independent));
                break;
            case R.id.i_reuters:
                fragment = NewsFeedFragment.newInstance("reuters", getResources().getString(R.string.reuters));
                break;
        }
        return fragment;
    }

    /*
    ENG: The method of switching fragments between themselves
    RU: Метод переключения фрагментов между собой
    */
    public void setFragment(Fragment fragment, int layoutResIs) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        String tag = fragment.getClass().getSimpleName();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.content_show, R.anim.content_hide);
        fragmentTransaction.replace(layoutResIs, fragment, tag);
        fragmentTransaction.commit();
    }
}
