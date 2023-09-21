package com.example.mcs_uts;


public class NewsVertical {

    String newsTitleVertical, dateNewsVertical, previewNewsVertical,newsFullTitleVertical, newsFullArticleVertical;
    int newsImageVertical;

    public NewsVertical(String newsTitleVertical, String dateNewsVertical, String previewNewsVertical, String newsFullTitleVertical, String newsFullArticleVertical, int newsImageVertical) {
        this.newsTitleVertical = newsTitleVertical;
        this.dateNewsVertical = dateNewsVertical;
        this.previewNewsVertical = previewNewsVertical;
        this.newsFullTitleVertical = newsFullTitleVertical;
        this.newsFullArticleVertical = newsFullArticleVertical;
        this.newsImageVertical = newsImageVertical;
    }

    public String getNewsFullTitleVertical() {
        return newsFullTitleVertical;
    }

    public void setNewsFullTitleVertical(String newsFullTitleHorizontal) {
        this.newsFullTitleVertical = newsFullTitleHorizontal;
    }

    public String getNewsFullArticleVertical() {
        return newsFullArticleVertical;
    }

    public void setNewsFullArticleVertical(String newsFullArticleHorizontal) {
        this.newsFullArticleVertical = newsFullArticleHorizontal;
    }

    public String getNewsTitleVertical() {
        return newsTitleVertical;
    }

    public void setNewsTitleVertical(String newsTitleVertical) {
        this.newsTitleVertical = newsTitleVertical;
    }

    public String getDateNewsVertical() {
        return dateNewsVertical;
    }

    public void setDateNewsVertical(String dateNewsVertical) {
        this.dateNewsVertical = dateNewsVertical;
    }

    public String getPreviewNewsVertical() {
        return previewNewsVertical;
    }

    public void setPreviewNewsVertical(String previewNewsVertical) {
        this.previewNewsVertical = previewNewsVertical;
    }

    public int getNewsImageVertical() {
        return newsImageVertical;
    }

    public void setNewsImageVertical(int newsImageVertical) {
        this.newsImageVertical = newsImageVertical;
    }
}
