package com.example.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ArticleManager {

    private final ArticleRepository articleRepository;

    @Transactional
    public Long appendArticle(final String title, final String content) {
        final ArticleSnapShot articleSnapShot = ArticleSnapShot.builder()
                                                               .title(title)
                                                               .content(content)
                                                               .build();
        final Article article = Article.builder().build();

        article.update(articleSnapShot);
        final Article savedArticle = articleRepository.save(article);

        return savedArticle.getId();
    }
}
