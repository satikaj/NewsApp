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
import androidx.recyclerview.widget.RecyclerView;

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.ViewHolder> {

    static Context context;
    static NewsStory[] newsStories;

    public RelatedNewsAdapter(Context context, NewsStory[] newsStories) {
        this.context = context;
        this.newsStories = newsStories;
    }

    @NonNull
    @Override
    public RelatedNewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.related_stories_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedNewsAdapter.ViewHolder holder, int position) {
        holder.relatedImg.setImageResource(newsStories[position].getImage_id());
        holder.relatedHeadline.setText(newsStories[position].getHeadline());
    }

    @Override
    public int getItemCount() {
        return newsStories.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView relatedImg;
        TextView relatedHeadline;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            relatedImg = itemView.findViewById(R.id.relatedImg);
            relatedHeadline = itemView.findViewById(R.id.relatedHeadline);

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
