package com.example.mcs_uts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_horizontal_details);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.action_bar_custom);
        }

        String newsTitleFullHorizontal = getIntent().getStringExtra("newsTitleFullHorizontal");
        String newsDateHorizontal = getIntent().getStringExtra("newsDateHorizontal");
        String newsArticleFullHorizontal = getIntent().getStringExtra("newsArticleFullHorizontal");
        int newsImageInt = getIntent().getIntExtra("newsImage",0);

        TextView newsTitle = findViewById(R.id.newsTitleFullHorizontal);
        TextView newsDate = findViewById(R.id.newsDateHorizontal);
        TextView newsArticle = findViewById(R.id.newsArticleFullHorizontal);
        ImageView newsImage = findViewById(R.id.newsImage);

        newsTitle.setText(newsTitleFullHorizontal);
        newsDate.setText(newsDateHorizontal);
        newsArticle.setText(newsArticleFullHorizontal);
        newsImage.setImageResource(newsImageInt);


    }
}