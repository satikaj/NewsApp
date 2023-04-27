package com.example.newsapp;

import java.io.Serializable;

public class NewsStory implements Serializable {

    String headline;
    String author;
    String story;
    int image_id;

    public NewsStory(String headline, String author, String story, int image_id) {
        this.headline = headline;
        this.author = author;
        this.story = story;
        this.image_id = image_id;
    }

    public String getHeadline() {
        return headline;
    }

    public String getAuthor() {
        return author;
    }

    public String getStory() {
        return story;
    }
    public int getImage_id() {
        return image_id;
    }
}
