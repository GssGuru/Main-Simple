package newspaper.gamestudiostandart.newspaper.aplication.main.fragment;

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

import newspaper.gamestudiostandart.newspaper.R;
import newspaper.gamestudiostandart.newspaper.utils.model.NewsModel;

/*Simple adapter for News*/
public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder> {

    private Context context;
    private ArrayList<NewsModel> list;

    AdapterNews(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    @NonNull
    @Override
    public AdapterNews.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.i_news, parent, false);
        return new AdapterNews.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterNews.ViewHolder holder, final int position) {

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
                    .skipMemoryCache( true )
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
                if(!TextUtils.isEmpty(newsModel.getUrl())) {
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

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_image, iv_share;
        private TextView tv_title, tv_description, tv_time;
        private LinearLayout ll_click;
        private FrameLayout fl_media_content;
        private ProgressBar pb_image;

        ViewHolder(View itemView) {
            super(itemView);
            pb_image = itemView.findViewById(R.id.pb_image);
            fl_media_content = itemView.findViewById(R.id.fl_media_content);
            ll_click = itemView.findViewById(R.id.ll_click);
            iv_image = itemView.findViewById(R.id.iv_image);
            iv_share = itemView.findViewById(R.id.iv_share);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }

    void addAll(ArrayList<NewsModel> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
}
