package guru.gss.mainsimple.ui.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import butterknife.ButterKnife;
import guru.gss.mainsimple.R;
import guru.gss.mainsimple.ui.BaseActivity;
import guru.gss.mainsimple.ui.main.fragment.FragmentNews;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, FragmentNews.OnFragmentInteractionListener {

    private int mIdSelectedItem;
    private DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
        ButterKnife.bind(this);

        mDrawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        setFragment(getMainFragment(R.id.i_the_washington_post), R.id.fl_fragment_conteiner);
        mIdSelectedItem = R.id.i_the_washington_post;

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        int id = item.getItemId();
        if (id != mIdSelectedItem) {
            mIdSelectedItem = id;
            setFragment(getMainFragment(id), R.id.fl_fragment_conteiner);
        }
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void openDrover() {
        mDrawer.openDrawer(GravityCompat.START);
    }
}