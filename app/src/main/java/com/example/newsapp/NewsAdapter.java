package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    static Context context;
    static NewsStory[] newsStories;

    public NewsAdapter(Context context, NewsStory[] newsStories) {
        this.context = context;
        this.newsStories = newsStories;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        holder.newsImg.setImageResource(newsStories[position].getImage_id());
        holder.newsHeadline.setText(newsStories[position].getHeadline());
    }

    @Override
    public int getItemCount() {
        return newsStories.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImg;
        TextView newsHeadline;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            newsImg = itemView.findViewById(R.id.newsImg);
            newsHeadline = itemView.findViewById(R.id.newsHeadline);

            // Show article on click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, NewsStoryFragment.newInstance(newsStories, getAdapterPosition()), null)
                            .setReorderingAllowed(true)
                            .addToBackStack("News Story")
                            .commit();
                }
            });
        }
    }
}
