package com.example.domain.article;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "articles")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "article", cascade = CascadeType.PERSIST)
    private final List<ArticleSnapShot> articleSnapShots = new ArrayList<>();

    @Builder
    public Article() {
        this.deletedAt = null;
    }

    public void addSnapshot(ArticleSnapShot articleSnapShot) {
        this.articleSnapShots.add(articleSnapShot);
    }

    public ArticleSnapShot getLastedArticle() {
        return this.articleSnapShots.stream()
                                    .sorted(Comparator.comparing(ArticleSnapShot::getCreatedAt).reversed())
                                    .findFirst()
                                    .orElseThrow();
    }
}
