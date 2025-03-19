package com.example.application.article;

import com.example.application.article.request.ArticleAppendServiceRequest;
import com.example.article.ArticleManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleManager articleManager;

    public Long append(final ArticleAppendServiceRequest request) {
        return articleManager.appendArticle(request.title(), request.content());
    }
}
