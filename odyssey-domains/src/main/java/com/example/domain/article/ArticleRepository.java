package com.example.domain.article;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleCustomRepository {

    Optional<Article> findByIdAndDeletedAtIsNull(Long id);
}
