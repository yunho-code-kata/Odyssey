package com.example.api.article.request;

import com.example.application.article.request.ArticleModifyServiceRequest;
import jakarta.validation.constraints.NotBlank;

public record ArticleModifyRequest(
        @NotBlank
        String title,
        @NotBlank
        String content
) {

    public ArticleModifyServiceRequest toServiceRequest(Long id) {
        return ArticleModifyServiceRequest.builder()
                                          .id(id)
                                          .title(this.title)
                                          .content(this.content)
                                          .build();
    }
}
