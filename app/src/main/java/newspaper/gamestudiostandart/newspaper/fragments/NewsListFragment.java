package newspaper.gamestudiostandart.newspaper.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.hlab.animatedPullToRefresh.AnimatedPullToRefreshLayout;

import net.cachapa.expandablelayout.ExpandableLayout;
import java.util.ArrayList;
import me.everything.android.ui.overscroll.IOverScrollDecor;
import me.everything.android.ui.overscroll.IOverScrollUpdateListener;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;
import me.everything.android.ui.overscroll.VerticalOverScrollBounceEffectDecorator;
import me.everything.android.ui.overscroll.adapters.RecyclerViewOverScrollDecorAdapter;
import newspaper.gamestudiostandart.newspaper.Function;
import newspaper.gamestudiostandart.newspaper.R;
import newspaper.gamestudiostandart.newspaper.dialogs.ErrorDialig;
import newspaper.gamestudiostandart.newspaper.model.NewsModel;

public class NewsListFragment extends MvpAppCompatFragment implements NewsFragmentView {

    @InjectPresenter
    NewsFragmentPresenter presenter;

    private static final String NEWS_AUTHOR = "news_author";
    private String author;

    private NewsAdapter newsAdapter;
    private ProgressBar progress;
    private RecyclerView recyclerView;
    private LinearLayout fl_items_not_found;
    private AnimatedPullToRefreshLayout refresh_view;

    public NewsListFragment() {}

    /*the fragment takes String author and makes a request based on this  String and shows a news list with help from RecyclerView*/
    public static NewsListFragment newInstance(String author) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putString(NEWS_AUTHOR, author);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            author = getArguments().getString(NEWS_AUTHOR);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f_news, container, false);

        progress = v.findViewById(R.id.progress);
        refresh_view = v.findViewById(R.id.refresh_view);

        refresh_view.setOnRefreshListener(new AnimatedPullToRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getNewsList(author);
            }
        });

        recyclerView = v.findViewById(R.id.recyclerView);
        fl_items_not_found = v.findViewById(R.id.fl_items_not_found);
        newsAdapter = new NewsAdapter(getContext());
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_news_animation);
        recyclerView.setLayoutAnimation(animation);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsAdapter);
        progress.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        fl_items_not_found.setVisibility(View.GONE);

        return v;
    }

    /*Do reqwest only when fragment in screen*/
    boolean mUserVisibleHint;

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        mUserVisibleHint = menuVisible;
        if (menuVisible && isResumed()) {
            onResume();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mUserVisibleHint) {
            if (newsAdapter.getItemCount() == 0) {
                presenter.getNewsList(author);
            }
        }
    }

    /*request success*/
    @Override
    public void setListNews(ArrayList<NewsModel> list) {
        if (list.size() == 0) {
            if(refresh_view.isRefreshing()){
                refresh_view.refreshComplete();
            }
            if (fl_items_not_found.getVisibility() != View.VISIBLE) {
                Function.showContentView(fl_items_not_found, progress);
            }
        } else {
            newsAdapter.addAll(list);
            if(refresh_view.isRefreshing()){
                refresh_view.refreshComplete();
            } else {
                Function.showContentView(recyclerView, progress);
            }
        }

    }

    @Override
    public void someList() {
        if(refresh_view.isRefreshing()){
            refresh_view.refreshComplete();
        }
    }


    /*When we get error from request we show ErrorDialog*/
    @Override
    public void setError() {
        ErrorDialig mErrorDialig = ErrorDialig.newInstance();
        mErrorDialig.registerInterfaceCallback(new ErrorDialig.InterfaceCallback() {
            @Override
            public void refresh() {
                presenter.getNewsList(author);
            }

            @Override
            public void exit() {
                getActivity().finish();
            }
        });
        mErrorDialig.show(getActivity().getSupportFragmentManager(), mErrorDialig.getClass().getSimpleName());
    }

}