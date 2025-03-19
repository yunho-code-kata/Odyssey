package com.example.application.article.request;

import lombok.Builder;

@Builder
public record ArticleAppendServiceRequest(
        String title,
        String content
){

}
