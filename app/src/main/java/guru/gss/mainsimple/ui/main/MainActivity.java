package guru.gss.mainsimple.ui.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import guru.gss.mainsimple.R;
import guru.gss.mainsimple.ui.BaseActivity;
import guru.gss.mainsimple.ui.main.fragment.NewsFeedFragment;

/*
ENG: The main activity with the Navigation menu and container for the fragments. Using the menu, we will switch fragments
RU: Главное активити с Навигационным меню и контейнером для фрагментов. С помощью меню будем переключать фрагменти
*/
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, NewsFeedFragment.OnFragmentInteractionListener {

    /*
    ENG: Prepare elements of the Navigation menu
    RU: Подготовить элементы Навигационного меню
    */
    @BindView(R.id.nav_view) NavigationView nav_view;
    @BindView(R.id.drawer_layout) DrawerLayout drawer_layout;

    private int mIdSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
        ButterKnife.bind(this);

        /*
        ENG: Work with the Navigation menu
        RU: Работаем с Navigation menu
        */
        nav_view.setNavigationItemSelectedListener(this);
        nav_view.getMenu().getItem(0).setChecked(true);
        mIdSelectedItem = R.id.i_the_washington_post;
        setFragment(getMainFragment(R.id.i_the_washington_post), R.id.fl_fragment_conteiner);

    }

    /*
    ENG: Navigation menu. item click handler
    RU: Navigation menu. обработчик click по позициям
    */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        int id = item.getItemId();
        if (id != mIdSelectedItem) {
            mIdSelectedItem = id;
            setFragment(getMainFragment(id), R.id.fl_fragment_conteiner);
        }
        drawer_layout.closeDrawer(GravityCompat.START);
        return true;
    }

    /*
    ENG: Override the Backspace button to check if the Navigation menu is open.
    RU: Переопределить кнопку Backspace для проверки не открыто ли Navigation menu
    */
    @Override
    public void onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*
    ENG: Interface method from Fragment NewsFeed for opening the Navigation menu
    RU: Метод интерфейса из Fragment NewsFeed для открытия Navigation menu
    */
    @Override
    public void openDrover() {
        drawer_layout.openDrawer(GravityCompat.START);
    }
}