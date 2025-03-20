package com.example.api.article.response;

import com.example.domain.article.ArticleDetail;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record ArticleResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ArticleResponse from(ArticleDetail detail) {
        return ArticleResponse.builder()
                              .id(detail.id())
                              .title(detail.title())
                              .content(detail.content())
                              .createdAt(detail.createdAt())
                              .updatedAt(detail.updatedAt())
                              .build();
    }
}
