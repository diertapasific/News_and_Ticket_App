package com.example.mcs_uts;

public class NewsHorizontal {

    String newsTitleHorizontal, dateNewsHorizontal, newsFullTitleHorizontal, newsFullArticleHorizontal;
    int newsImageHorizontal;

    public String getNewsFullTitleHorizontal() {
        return newsFullTitleHorizontal;
    }

    public void setNewsFullTitleHorizontal(String newsFullTitleHorizontal) {
        this.newsFullTitleHorizontal = newsFullTitleHorizontal;
    }

    public String getNewsFullArticleHorizontal() {
        return newsFullArticleHorizontal;
    }

    public void setNewsFullArticleHorizontal(String newsFullArticleHorizontal) {
        this.newsFullArticleHorizontal = newsFullArticleHorizontal;
    }

    public NewsHorizontal(String newsTitleHorizontal, String dateNewsHorizontal, String newsFullTitleHorizontal,String newsFullArticleHorizontal,int newsImageHorizontal) {
        this.newsTitleHorizontal = newsTitleHorizontal;
        this.dateNewsHorizontal = dateNewsHorizontal;
        this.newsFullTitleHorizontal = newsFullTitleHorizontal;
        this.newsFullArticleHorizontal = newsFullArticleHorizontal;
        this.newsImageHorizontal = newsImageHorizontal;
    }

    public String getDateNewsHorizontal() {
        return dateNewsHorizontal;
    }

    public void setDateNewsHorizontal(String dateNewsHorizontal) {
        this.dateNewsHorizontal = dateNewsHorizontal;
    }

    public String getNewsTitleHorizontal() {
        return newsTitleHorizontal;
    }

    public void setNewsTitleHorizontal(String newsTitleHorizontal) {
        this.newsTitleHorizontal = newsTitleHorizontal;
    }

    public int getNewsImageHorizontal() {
        return newsImageHorizontal;
    }

    public void setNewsImageHorizontal(int newsImageHorizontal) {
        this.newsImageHorizontal = newsImageHorizontal;
    }
}
