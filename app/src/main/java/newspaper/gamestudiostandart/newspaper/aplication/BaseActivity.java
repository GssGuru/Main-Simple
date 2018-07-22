package newspaper.gamestudiostandart.newspaper.aplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;

import com.arellomobile.mvp.MvpAppCompatActivity;

import newspaper.gamestudiostandart.newspaper.R;
import newspaper.gamestudiostandart.newspaper.utils.model.Category;

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
            case R.id.i_my_favorite:
                category = Category.STARRED;
                break;
            case R.id.i_popular:
                category = Category.POPULAR;
                break;
            case R.id.i_tehnology:
                category = Category.TEHNOLOGY;
                break;
            case R.id.i_sport:
                category = Category.SPORT;
                break;
            case R.id.i_busines:
                category = Category.BUSINESS;
                break;
            case R.id.i_other:
                category = Category.OTHER;
                break;
        }
        return category;
    }
}
