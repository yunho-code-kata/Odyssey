package com.example.domain.article;

import com.querydsl.core.annotations.QueryProjection;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record ArticleDetail(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    //TODO: 제거
    @QueryProjection
    public ArticleDetail {
    }

    public static ArticleDetail of(
            final Article article,
            final ArticleSnapShot articleSnapShot
    ) {
        return ArticleDetail.builder()
                            .id(article.getId())
                            .title(articleSnapShot.getTitle())
                            .content(articleSnapShot.getContent())
                            .createdAt(article.getCreatedAt())
                            .updatedAt(articleSnapShot.getCreatedAt())
                            .build();
    }
}
