package com.example.domain.article;

public abstract class ArticleFixture {

    public static ArticleSnapShot create() {
        Article article = new Article();
        return ArticleSnapShot.create("제목", "내용", article);
    }
}
