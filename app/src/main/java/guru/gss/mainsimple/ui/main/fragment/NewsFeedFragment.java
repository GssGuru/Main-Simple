package guru.gss.mainsimple.ui.main.fragment;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import guru.gss.mainsimple.R;
import guru.gss.mainsimple.model.interactors.news.NewsInteractor;
import guru.gss.mainsimple.model.repository.network.NetworkRepositoryImpl;
import guru.gss.mainsimple.ui.BaseFragment;
import guru.gss.mainsimple.ui.utils.utils.ContentAnimator;
import guru.gss.mainsimple.utils.model.NewsModel;

/*
ENG: Fragment for working with news feed
RU: Фрагмент для работы с новосной лентой
*/
public class NewsFeedFragment extends BaseFragment implements NewsFeedFragmentVew {

    /*
    ENG: Initialize Presenter
    RU: Инициализируем Presenter
    */
    @InjectPresenter
    NewsFeedPresenter presenter;
    @ProvidePresenter
    NewsFeedPresenter providePresenter() {
        return new NewsFeedPresenter(new NewsInteractor(new NetworkRepositoryImpl()));
    }

    /*
    ENG: Prepare elements to work with fragment
    RU: Подготовить элементы для работы с фрагментом
    */
    private static final String NEWS_AUTHOR = "news_author";
    private static final String NEWS_TITLE = "news_title";
    private String author, title;
    private NewsFeedAdapter newsFeedAdapter;

    /*
    ENG: Prepare Views elements
    RU: Подготовить элементы Views
    */
    @BindView(R.id.fl_items_not_found)
    LinearLayout fl_items_not_found;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_view)
    SwipeRefreshLayout refresh_view;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.app_bar)
    AppBarLayout app_bar;

    public NewsFeedFragment() {
    }

    /*
    ENG: Transfer to the Fragment information about the author
    RU: Передаем в Фрагмент информацию про автора
    */
    public static NewsFeedFragment newInstance(String author, String title) {
        NewsFeedFragment fragment = new NewsFeedFragment();
        Bundle args = new Bundle();
        args.putString(NEWS_AUTHOR, author);
        args.putString(NEWS_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            author = getArguments().getString(NEWS_AUTHOR);
            title = getArguments().getString(NEWS_TITLE);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f_news, container, false);

        /*
        ENG: Initialize the views
        RU: Инициализировать view
        */
        ButterKnife.bind(this, v);
        setupToolbar();
        setupListView();
        presenter.getNewsList(author);
        return v;
    }

    /*
    ENG: Show news feed
    RU: Показать новостную ленту
    */
    @Override
    public void setListNews(ArrayList<NewsModel> list) {
        if (list.size() == 0) {
            if (fl_items_not_found.getVisibility() != View.VISIBLE) {
                showContentAnimation(new ContentAnimator(), fl_items_not_found, progress);
            }
        } else {
            newsFeedAdapter.addAll(list);
            if (recyclerView.getVisibility() != View.VISIBLE) {
                showContentAnimation(new ContentAnimator(), recyclerView, progress);
            }

        }
        hideRefreshView(refresh_view);
    }

    /*
    ENG: Show View with "Empty List"
    RU: Показать View с надписью "Empty List"
    */
    @Override
    public void setEmptyList() {
        hideRefreshView(refresh_view);
    }

    /*
    ENG: Show Error Dialog
    RU: Показать диалоговое окно с сообщением об ошибке
    */
    @Override
    public void setError() {
        hideRefreshView(refresh_view);
        DialigError mDialigError = DialigError.newInstance();
        mDialigError.registerInterfaceCallback(new DialigError.InterfaceCallback() {
            @Override
            public void refresh() {
                presenter.getNewsList(author);
            }

            @Override
            public void exit() {
                Objects.requireNonNull(getActivity()).finish();
            }
        });
        mDialigError.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), mDialigError.getClass().getSimpleName());
    }

    /*
    ENG: Initialization and work with Toolbar
    RU: Инициализация и работа с Toolbar
    */
    private void setupToolbar() {
        mToolbar.setTitle(String.valueOf(title));
        mToolbar.setTitleTextColor(getResources().getColor(R.color.colorIcons));
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        mToolbar.setNavigationIcon(R.drawable.ic_menu);
        Objects.requireNonNull(mToolbar.getNavigationIcon()).setColorFilter(getResources().getColor(R.color.colorIcons), PorterDuff.Mode.SRC_ATOP);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.openDrover();
                }
            }
        });
        app_bar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                mToolbar.setAlpha(1.5f - ((float) Math.abs(verticalOffset) / ((float) appBarLayout.getTotalScrollRange() / 3)));
            }
        });
    }

    /*
    ENG: Initialization of the news feed
    RU: Инициализация новостной ленты
    */
    private void setupListView() {
        newsFeedAdapter = new NewsFeedAdapter(getContext());
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_news_animation);
        recyclerView.setLayoutAnimation(animation);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsFeedAdapter);
        refresh_view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getNewsList(author);
            }
        });
    }

    /*
    ENG: Method of list update
    RU: Метод обновления списка
    */
    private void hideRefreshView(SwipeRefreshLayout refresh_view) {
        if (refresh_view.isShown()) {
            refresh_view.setRefreshing(false);
        }
    }

    /*
    ENG: Add an interface with method to Fragment.
    RU: Добавляем нашему Фрагменту интерфейс с методом
    */
    private OnFragmentInteractionListener mListener;
    public interface OnFragmentInteractionListener {
        void openDrover();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}