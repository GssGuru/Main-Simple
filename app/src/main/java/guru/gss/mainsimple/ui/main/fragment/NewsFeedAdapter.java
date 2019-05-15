package guru.gss.mainsimple.ui.main.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import guru.gss.mainsimple.R;
import guru.gss.mainsimple.utils.model.NewsModel;

/*
ENG: Simple adapter showing news feed
RU: Простой adapter отображающий новостную ленту
*/
public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ViewHolder> {

    /*
    ENG: Prepare items to work with the list
    RU: Подготовить элементы для работы со списком
    */
    private Context context;
    private ArrayList<NewsModel> list;

    NewsFeedAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    /*
    ENG: Basic elements for working with a list
    RU: Базовые элементы для работы со списком
    */
    @NonNull
    @Override
    public NewsFeedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.i_news, parent, false);
        return new NewsFeedAdapter.ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /*
    ENG: Work with View for each position in the list
    RU: Работаем с View для каждой позиции в списке
    */
    @Override
    public void onBindViewHolder(@NonNull final NewsFeedAdapter.ViewHolder holder, final int position) {

        final NewsModel newsModel = list.get(position);

        if (!TextUtils.isEmpty(newsModel.getPublishedAt())) {
            holder.tv_time.setVisibility(View.VISIBLE);
            holder.tv_time.setText(newsModel.getPublishedAt());
        }

        if (!TextUtils.isEmpty(newsModel.getDescription())) {
            holder.tv_description.setVisibility(View.VISIBLE);
            holder.tv_description.setText(newsModel.getDescription());
        }

        if (!TextUtils.isEmpty(newsModel.getUrlToImage())) {
            holder.fl_media_content.setVisibility(View.VISIBLE);

            Glide.with(context)
                    .load(newsModel.getUrlToImage())
                    .skipMemoryCache(true)
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            holder.pb_image.setVisibility(View.GONE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            holder.pb_image.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(holder.iv_image);
        }

        holder.ll_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (!TextUtils.isEmpty(newsModel.getUrl())) {
                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(newsModel.getUrl())));
                }
            }
        });

        holder.iv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                if (!TextUtils.isEmpty(newsModel.getUrl())) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, newsModel.getUrl());
                    sendIntent.setType("text/plain");
                    context.startActivity(Intent.createChooser(sendIntent, context.getResources().getText(R.string.text_send_to)));
                }
            }
        });

        if (!TextUtils.isEmpty(newsModel.getTitle())) {
            holder.tv_title.setVisibility(View.VISIBLE);
            holder.tv_title.setText(newsModel.getTitle());
        }
    }

    /*
    ENG: prepare Views elements
    RU: подготовить элементы Views
    */
    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_image) ImageView iv_image;
        @BindView(R.id.iv_share) ImageView iv_share;
        @BindView(R.id.tv_title) TextView tv_title;
        @BindView(R.id.tv_description) TextView tv_description;
        @BindView(R.id.tv_time) TextView tv_time;
        @BindView(R.id.ll_click) LinearLayout ll_click;
        @BindView(R.id.fl_media_content) FrameLayout fl_media_content;
        @BindView(R.id.pb_image) ProgressBar pb_image;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    /*
    ENG: Transfer the news list to the adapter
    RU: Передаем список новостей в адаптер
    */
    void addAll(ArrayList<NewsModel> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
}
