package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsStoryFragment extends Fragment {

    RecyclerView relatedNewsRecyclerView;
    RecyclerView.LayoutManager relatedNewsLayoutManager;
    RelatedNewsAdapter relatedNewsAdapter;

    private static final String NEWS_STORIES = "newsStories";
    private static final String POSITION = "position";

    private NewsStory[] newsStories;
    private int position;

    public NewsStoryFragment() {
        // Required empty public constructor
    }

    public static NewsStoryFragment newInstance(NewsStory[] newsStories, int position) {
        // Make a new instance of the fragment
        NewsStoryFragment fragment = new NewsStoryFragment();
        Bundle args = new Bundle();
        args.putSerializable(NEWS_STORIES, newsStories);
        args.putInt(POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Initialise the variables
            newsStories = (NewsStory[]) getArguments().getSerializable(NEWS_STORIES);
            position = getArguments().getInt(POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_story, container, false);

        ImageView image = view.findViewById(R.id.image);
        TextView headline = view.findViewById(R.id.headline);
        TextView author = view.findViewById(R.id.author);
        TextView story = view.findViewById(R.id.story);

        // Display article info
        image.setImageResource(newsStories[position].getImage_id());
        headline.setText(newsStories[position].getHeadline());
        author.setText("by " + newsStories[position].getAuthor());
        story.setText(newsStories[position].getStory());

        // Related News Recycler View
        relatedNewsRecyclerView = view.findViewById(R.id.relatedStoriesRV);
        relatedNewsAdapter = new RelatedNewsAdapter(view.getContext(), newsStories);
        relatedNewsLayoutManager = new LinearLayoutManager(view.getContext());
        relatedNewsRecyclerView.setAdapter(relatedNewsAdapter);
        relatedNewsRecyclerView.setLayoutManager(relatedNewsLayoutManager);

        // Inflate the layout for this fragment
        return view;
    }
}