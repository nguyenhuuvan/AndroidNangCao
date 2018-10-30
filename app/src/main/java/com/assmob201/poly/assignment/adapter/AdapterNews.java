package com.assmob201.poly.assignment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.assmob201.poly.assignment.R;
import com.assmob201.poly.assignment.ui.WebViewsActivity;
import com.assmob201.poly.assignment.model.News;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder> {
    private Context context;

    private List<News> news;

    public AdapterNews(Context context, List<News> news) {
        this.context = context;
        this.news = news;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final News news = this.news.get(position);
        holder.tvTitle.setText(news.title);
        holder.tvDate.setText(news.pubDate);
        String des = news.description;
        try {
            String[] words = des.split("<p>",2);
            String[] words2 = words[1].split("</p>",2);
            holder.tvDes.setText(words2[0]);
        }catch (Exception e){
            Log.e("des",des);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebViewsActivity.class);
                intent.putExtra("link", news.link);
                intent.putExtra("title", news.title);
                context.startActivity(intent);
            }
        });
        Glide.with(context).load(news.image).into(holder.imgThumbs);

    }


    @Override
    public int getItemCount() {
        if (news == null) return 0;
        return news.size();

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDes;
        TextView tvDate;
        ImageView imgThumbs;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitleNews);
            tvDes = itemView.findViewById(R.id.tvDesNews);
            tvDate = itemView.findViewById(R.id.tvDateNews);
            imgThumbs = itemView.findViewById(R.id.imgAvatarNews);
        }

    }
}
