package newspaper.gamestudiostandart.newspaper.activitys;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;

import com.arellomobile.mvp.MvpAppCompatActivity;

import newspaper.gamestudiostandart.newspaper.R;
import newspaper.gamestudiostandart.newspaper.model.Category;

@SuppressLint("Registered")
public class BaseActivity extends MvpAppCompatActivity {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public Category updateMenuByNavigationId(int id) {

        Category category = null;
        switch (id) {
            case R.id.nav_general:
                category = Category.GENERAL;
                break;
            case R.id.nav_technology:
                category = Category.TEHNOLOGY;
                break;
            case R.id.nav_sport:
                category = Category.SPORT;
                break;
            case R.id.nav_business:
                category = Category.BUSINESS;
                break;
            case R.id.nav_politics:
                category = Category.POLITICS;
                break;
            case R.id.nav_entertainment:
                category = Category.ENTERTAINMENT;
                break;
            case R.id.nav_gaming:
                category = Category.GAMING;
                break;
            case R.id.nav_ecience_end_nature:
                category = Category.NATURE;
                break;
            case R.id.nav_music:
                category = Category.MUSIC;
                break;
        }
        return category;
    }
}
