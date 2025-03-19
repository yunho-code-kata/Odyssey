package com.example.api.article;

import com.example.api.article.request.ArticleAppendRequest;
import com.example.application.article.ArticleService;
import com.example.support.response.IdResponse;
import com.example.support.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public SuccessResponse<IdResponse> append(@RequestBody final ArticleAppendRequest request) {
        final Long id = articleService.append(request.toServiceRequest());
        return SuccessResponse.ok(IdResponse.from(id));
    }
}
