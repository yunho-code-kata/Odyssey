package com.example.service;

import com.example.domain.article.Article;
import com.example.domain.article.ArticleDetail;
import com.example.domain.article.ArticleRepository;
import com.example.domain.article.ArticleSnapShot;
import com.example.domain.article.ArticleSnapShotRepository;
import com.example.exception.ArticleException;
import com.example.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ArticleManager {

    private final ArticleRepository articleRepository;
    private final ArticleSnapShotRepository articleSnapShotRepository;

    @Transactional
    public Long appendArticle(final String title, final String content) {
        final Article article = Article.builder().build();
        final ArticleSnapShot articleSnapShot = ArticleSnapShot.create(title, content, article);

        article.addSnapshot(articleSnapShot);
        final Article savedArticle = articleRepository.save(article);

        return savedArticle.getId();
    }

    @Transactional
    public void modifyArticle(final Long id, final String title, final String content) {
        final Article article = getArticle(id);
        final ArticleSnapShot articleSnapShot = ArticleSnapShot.create(title, content, article);

        articleSnapShotRepository.save(articleSnapShot);
    }

    @Transactional(readOnly = true)
    public ArticleDetail findArticle(final Long id) {
        final Article article = getArticle(id);
        final ArticleSnapShot lastedArticle = article.getLastedArticle();

        return ArticleDetail.of(article, lastedArticle);
    }

    private Article getArticle(final Long id) {
        return articleRepository.findByIdAndDeletedAtIsNull(id)
                                .orElseThrow(() -> new BusinessException(ArticleException.NOT_FOUND_ERROR));
    }
}
