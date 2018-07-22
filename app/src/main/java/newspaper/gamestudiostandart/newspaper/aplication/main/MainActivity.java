package newspaper.gamestudiostandart.newspaper.aplication.main;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.Objects;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;
import newspaper.gamestudiostandart.newspaper.R;
import newspaper.gamestudiostandart.newspaper.aplication.BaseActivity;
import newspaper.gamestudiostandart.newspaper.aplication.search.SearchActivity;
import newspaper.gamestudiostandart.newspaper.aplication.main.fragment.FragmentList;
import newspaper.gamestudiostandart.newspaper.utils.model.ResourseModel;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, MainActivityView {

    @InjectPresenter
    MainActivityPresenter mPresenter;

    private int mIdSelectedItem;

    private DrawerLayout mDrawer;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Toolbar mToolbar;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        mDrawer = findViewById(R.id.drawer_layout);

        mToolbar = findViewById(R.id.toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        mToolbar.setNavigationIcon(R.drawable.ic_menu);
        Objects.requireNonNull(mToolbar.getNavigationIcon()).setColorFilter(getResources().getColor(R.color.colorIcons), PorterDuff.Mode.SRC_ATOP);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawer.openDrawer(GravityCompat.START);
            }
        });

        mFab = findViewById(R.id.fab);
        mFab.setColorFilter(getResources().getColor(R.color.colorIcons));
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity = new Intent(MainActivity.this, SearchActivity.class);
                activity.putExtra(SearchActivity.ENUM_RESOURSES, (Parcelable) mPresenter.getCategory());
                startActivityForResult(activity, SearchActivity.REQWEST_CODE_RESULT);
            }
        });

        AppBarLayout app_bar = findViewById(R.id.app_bar);
        app_bar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset < 0) {
                    if (mFab.isShown()) {
                        mFab.hide();
                    }
                } else {
                    if (!mFab.isShown()) {
                        mFab.show();
                    }
                }
                mToolbar.setAlpha(1.5f - ((float) Math.abs(verticalOffset) / ((float) appBarLayout.getTotalScrollRange() / 3)));
            }
        });

        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);
        OverScrollDecoratorHelper.setUpOverScroll(mViewPager);

        if (mPresenter.getChackList() != null) {
            setViewPagerContent(mPresenter.getChackList());
        } else {
            navigationView.getMenu().getItem(0).setChecked(true);
            mPresenter.getListRresourses();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
        int id = item.getItemId();
        if (id != mIdSelectedItem) {
            mIdSelectedItem = id;
            mPresenter.getListRresourses(updateMenuByNavigationId(id));
        } else {
            mDrawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }

    @Override
    public void setList(ArrayList<ResourseModel> list) {
        mViewPager.setVisibility(View.VISIBLE);
        setViewPagerContent(list);
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        }
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SearchActivity.REQWEST_CODE_RESULT) {
            if (resultCode == RESULT_OK) {
                mPresenter.getListRresourses();
            }
        }
    }

    public void setViewPagerContent(ArrayList<ResourseModel> list) {
        mToolbar.setTitle(String.valueOf(mPresenter.getCategory()));
        mToolbar.setTitleTextColor(getResources().getColor(R.color.colorIcons));
        if (list.size() != 0) {
            ArrayList<Fragment> myListFragments = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                myListFragments.add(FragmentList.newInstance(String.valueOf(list.get(i).getUrl())));
            }
            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), myListFragments);
            mViewPager.setAdapter(viewPagerAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
            for (int i = 0; i < list.size(); i++) {
                Objects.requireNonNull(mTabLayout.getTabAt(i)).setText(list.get(i).getName());
            }
        }
    }
}