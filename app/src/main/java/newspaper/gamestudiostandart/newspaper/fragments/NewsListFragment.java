package newspaper.gamestudiostandart.newspaper.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

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
    private ExpandableLayout expandable_layout;

    public NewsListFragment() {
    }

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f_news, container, false);

        progress = v.findViewById(R.id.progress);

        expandable_layout = v.findViewById(R.id.expandable_layout);
        recyclerView = v.findViewById(R.id.recyclerView);
        fl_items_not_found = v.findViewById(R.id.fl_items_not_found);
        newsAdapter = new NewsAdapter(getContext());
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_news_animation);
        recyclerView.setLayoutAnimation(animation);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        OverScrollDecoratorHelper.setUpOverScroll(recyclerView, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
        recyclerView.setAdapter(newsAdapter);

        VerticalOverScrollBounceEffectDecorator decor = new VerticalOverScrollBounceEffectDecorator(new RecyclerViewOverScrollDecorAdapter(recyclerView, new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return 0;
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }
        }));
        
        decor.setOverScrollUpdateListener(new IOverScrollUpdateListener() {
            @Override
            public void onOverScrollUpdate(IOverScrollDecor decor, int state, float offset) {
                final View view = decor.getView();
                if (offset > 140 && state == 3) {
                    if(!expandable_layout.isExpanded()){
                        expandable_layout.expand(true);
                        presenter.getNewsList(author);
                    }
                }
            }
        });

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
            if(expandable_layout.isExpanded()){
                expandable_layout.collapse(true);
            }
            if (fl_items_not_found.getVisibility() != View.VISIBLE) {
                Function.showContentView(fl_items_not_found, progress);
            }
        } else {
            newsAdapter.addAll(list);
            if(expandable_layout.isExpanded()){
                expandable_layout.collapse(true);
            } else {
                Function.showContentView(recyclerView, progress);
            }
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