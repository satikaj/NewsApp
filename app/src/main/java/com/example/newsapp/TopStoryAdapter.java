package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class TopStoryAdapter extends RecyclerView.Adapter<TopStoryAdapter.ViewHolder> {

    static Context context;
    static NewsStory[] newsStories;

    public TopStoryAdapter(Context context, NewsStory[] newsStories) {
        this.context = context;
        this.newsStories = newsStories;
    }

    @NonNull
    @Override
    public TopStoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_stories_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopStoryAdapter.ViewHolder holder, int position) {
        holder.topStoryImg.setImageResource(newsStories[position].getImage_id());
    }

    @Override
    public int getItemCount() {
        return newsStories.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView topStoryImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            topStoryImg = itemView.findViewById(R.id.topStoryImg);

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