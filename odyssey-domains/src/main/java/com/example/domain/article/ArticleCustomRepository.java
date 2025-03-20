package com.example.domain.article;

import java.util.Optional;

public interface ArticleCustomRepository {

    Optional<ArticleDetail> findLatestArticle(Long id);
}
