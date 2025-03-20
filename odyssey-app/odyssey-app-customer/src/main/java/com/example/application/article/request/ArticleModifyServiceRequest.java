package com.example.application.article.request;

import lombok.Builder;

@Builder
public record ArticleModifyServiceRequest(
        Long id,
        String title,
        String content
) {
}
