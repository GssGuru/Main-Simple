package newspaper.gamestudiostandart.newspaper.aplication.search;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.Objects;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;
import newspaper.gamestudiostandart.newspaper.R;
import newspaper.gamestudiostandart.newspaper.aplication.BaseActivity;
import newspaper.gamestudiostandart.newspaper.utils.ShowContentAnimation;
import newspaper.gamestudiostandart.newspaper.utils.model.Category;
import newspaper.gamestudiostandart.newspaper.utils.model.ResourseModel;

public class SearchActivity extends BaseActivity implements SearchActivityView {

    @InjectPresenter
    SearchActivityPresenter mPresenter;

    public static final int REQWEST_CODE_RESULT = 1;
    public static final String ENUM_RESOURSES = "enum_resourses";
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;

    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_search);

        Category category = getIntent().getParcelableExtra(ENUM_RESOURSES);
        mProgressBar = findViewById(R.id.pb_loading);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        toolbar.inflateMenu(R.menu.m_search);
        toolbar.setTitle(String.valueOf(category));

        MenuItem saveItem = toolbar.getMenu().findItem(R.id.btn_save);
        saveItem.getIcon().setColorFilter(getResources().getColor(R.color.colorIcons), PorterDuff.Mode.SRC_ATOP);
        saveItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                mPresenter.save();
                return false;
            }
        });

        MenuItem searchItem = toolbar.getMenu().findItem(R.id.btn_search);
        searchItem.getIcon().setColorFilter(getResources().getColor(R.color.colorIcons), PorterDuff.Mode.SRC_ATOP);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String qwerty = newText.toLowerCase();
                final ArrayList<ResourseModel> filteredModelList = new ArrayList<>();
                for (ResourseModel model : mPresenter.getListResourses()) {
                    final String text = model.getName().toLowerCase();
                    if (text.contains(qwerty)) {
                        filteredModelList.add(model);
                    }
                }
                adapter.addAll(filteredModelList);
                return true;
            }
        });

        toolbar.setNavigationIcon(R.drawable.ic_close);
        Objects.requireNonNull(toolbar.getNavigationIcon()).setColorFilter(getResources().getColor(R.color.colorIcons), PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        adapter = new Adapter();
        mRecyclerView = findViewById(R.id.recycler_view);
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_search_animation);
        mRecyclerView.setLayoutAnimation(animation);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        OverScrollDecoratorHelper.setUpOverScroll(mRecyclerView, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        mRecyclerView.setAdapter(adapter);

        if (mPresenter.getListResourses() != null) {
            adapter.addAll(mPresenter.getListResourses());
            mRecyclerView.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.GONE);
        } else {
            mPresenter.getListRresourses(category);
        }
    }

    @Override
    public void setList(ArrayList<ResourseModel> list) {
        new ShowContentAnimation(mRecyclerView, mProgressBar);
        adapter.addAll(list);
    }

    @Override
    public void listSaved() {
        setResult(RESULT_OK);
        this.finish();
    }

    @Override
    public void listSavedFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
