package guru.gss.mainsimple.aplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import guru.gss.mainsimple.R;
import guru.gss.mainsimple.aplication.main.fragment.FragmentNews;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public Fragment getMainFragment(int id) {
        Fragment fragment = null;
        switch (id) {
            case R.id.i_the_washington_post:
                fragment = FragmentNews.newInstance("the-washington-post", getResources().getString(R.string.the_washington_post));
                break;
            case R.id.i_the_new_york_times:
                fragment = FragmentNews.newInstance("the-new-york-times", getResources().getString(R.string.the_new_york_times));
                break;
            case R.id.i_the_telegraph:
                fragment = FragmentNews.newInstance("the-telegraph", getResources().getString(R.string.the_telegraph));
                break;
            case R.id.i_cnn:
                fragment = FragmentNews.newInstance("cnn", getResources().getString(R.string.cnn));
                break;
            case R.id.i_time:
                fragment = FragmentNews.newInstance("time", getResources().getString(R.string.time));
                break;
            case R.id.i_bbc_news:
                fragment = FragmentNews.newInstance("bbc-news", getResources().getString(R.string.bbc_news));
                break;
            case R.id.i_associated_press:
                fragment = FragmentNews.newInstance("associated-press", getResources().getString(R.string.associated_press));
                break;
            case R.id.i_independent:
                fragment = FragmentNews.newInstance("independent", getResources().getString(R.string.independent));
                break;
            case R.id.i_reuters:
                fragment = FragmentNews.newInstance("reuters", getResources().getString(R.string.reuters));
                break;
        }
        return fragment;
    }

    public void setFragment(Fragment fragment, int layoutResIs) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        String tag = fragment.getClass().getSimpleName();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.content_show, R.anim.content_hide);
        fragmentTransaction.replace(layoutResIs, fragment, tag);
        fragmentTransaction.commit();
    }
}
