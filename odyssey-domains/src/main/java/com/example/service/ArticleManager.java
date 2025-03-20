package com.example.service;

import com.example.domain.article.Article;
import com.example.domain.article.ArticleRepository;
import com.example.domain.article.ArticleSnapShot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ArticleManager {

    private final ArticleRepository articleRepository;

    @Transactional
    public Long appendArticle(final String title, final String content) {
        final Article article = Article.builder().build();
        final ArticleSnapShot articleSnapShot = ArticleSnapShot.builder()
                                                               .title(title)
                                                               .content(content)
                                                               .article(article)
                                                               .build();
        article.update(articleSnapShot);

        final Article savedArticle = articleRepository.save(article);

        return savedArticle.getId();
    }
}
