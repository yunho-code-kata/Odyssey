package com.example.api.article.request;

import com.example.application.article.request.ArticleAppendServiceRequest;
import jakarta.validation.constraints.NotBlank;

public record ArticleAppendRequest(
        @NotBlank
        String title,
        @NotBlank
        String content
) {

    public ArticleAppendServiceRequest toServiceRequest() {
        return ArticleAppendServiceRequest.builder()
                                          .title(this.title)
                                          .content(this.content)
                                          .build();
    }
}
