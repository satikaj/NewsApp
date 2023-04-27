package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView topStoryRecyclerView;
    RecyclerView.LayoutManager topStoryLayoutManager;
    TopStoryAdapter topStoryAdapter;

    RecyclerView newsRecyclerView;
    RecyclerView.LayoutManager newsLayoutManager;
    NewsAdapter newsAdapter;

    // News Stories
    NewsStory newsStory1 = new NewsStory(
            "'My daughter needs me': Victorian mum preparing to leave violent partner when he killed her",
            "Karen Sweeney",
            "Her relationship was violent and she feared being killed, but Bekkie-Rae Curren-Trinca had a plan to leave. The 28-year-old mother-of-one had been in contact with Warrnambool domestic violence support services half a dozen times in November 2019 and was ready to report Paul McDonough to police. He killed her before she could do anything.",
            R.drawable.news1
    );
    NewsStory newsStory2 = new NewsStory(
            "A look into the future of healthcare in Victoria",
            "Alicia Loxley",
            "The future of healthcare, and how Victorians interact with it, is expected to drastically change over the coming decades. It needs to as Melbourne cements its place as Australia's biggest city. Despite boasting the most ambitious health infrastructure program ever seen in Australia, more patients will need to stay at home for treatment.",
            R.drawable.news2
    );
    NewsStory newsStory3 = new NewsStory(
            "Farcical search for new AFL boss complete as Gillon McLachlan's replacement locked in",
            "WWOS staff",
            "Andrew Dillon will replace Gillon McLachlan as chief executive of the AFL. Sam McClure broke the news on 3AW radio on Wednesday night, reporting that Dillon had beaten AFL chief financial officer Travis Auld to the position. The appointment follows a messy search for\uFEFF McLachlan's successor, with the AFL boss announcing his resignation in April last year and initially planning to step down at the end of the 2022 season.",
            R.drawable.news3
    );
    NewsStory newsStory4 = new NewsStory(
            "Community consultation begins into second safe injecting room in Melbourne",
            "Allanah Sciberras",
            "Community consultation has begun over a second safe injecting room in Melbourne's CBD. The survey is part of a larger report, led by former Victorian top cop Ken Lay, which will seek broader community views on injecting drug use and the community's needs and expectations. Victoria's first medically supervised injecting room in North Richmond became a permanent service earlier this year.",
            R.drawable.news4
    );
    NewsStory newsStory5 = new NewsStory(
            "'It's immoral': Family without home for seven months after black mould nightmare",
            "Reid Butler",
            "A leaky washing machine in an upstairs apartment has led to seven months of hell for a Melbourne couple who are now effectively homeless with concerns about their young children's health. Carolyn and Philippe Bechervaise and their boys, aged five and eight, have been forced to live in unpredictable temporary accommodation since the excess moisture from the leak triggered a black mould infestation in their newly-bought Southbank home. It's completely out of our control and you feel totally helpless, Mrs Bechervaise told 9News.",
            R.drawable.news5
    );
    NewsStory[] newsStories = {newsStory1, newsStory2, newsStory3, newsStory4, newsStory5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Top Story Recycler View
        topStoryRecyclerView = findViewById(R.id.topStoriesRV);
        topStoryAdapter = new TopStoryAdapter(MainActivity.this, newsStories);
        topStoryLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        topStoryRecyclerView.setAdapter(topStoryAdapter);
        topStoryRecyclerView.setLayoutManager(topStoryLayoutManager);

        // News Recycler View
        newsRecyclerView = findViewById(R.id.newsRV);
        newsAdapter = new NewsAdapter(MainActivity.this, newsStories);
        newsLayoutManager = new GridLayoutManager(this, 2);
        newsRecyclerView.setAdapter(newsAdapter);
        newsRecyclerView.setLayoutManager(newsLayoutManager);
    }
}