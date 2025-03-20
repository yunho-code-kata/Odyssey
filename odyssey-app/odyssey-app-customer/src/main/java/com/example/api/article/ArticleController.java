package com.example.api.article;

import com.example.api.article.request.ArticleAppendRequest;
import com.example.api.article.request.ArticleModifyRequest;
import com.example.api.article.response.ArticleResponse;
import com.example.application.article.ArticleService;
import com.example.domain.article.ArticleDetail;
import com.example.support.response.IdResponse;
import com.example.support.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("/{id}")
    public SuccessResponse<Void> modify(
            @PathVariable final Long id,
            @RequestBody final ArticleModifyRequest request
    ) {
        articleService.modify(request.toServiceRequest(id));
        return SuccessResponse.emptyData();
    }

    @GetMapping("/{id}")
    public SuccessResponse<ArticleResponse> find(@PathVariable final Long id) {
        final ArticleDetail articleDetail = articleService.find(id);
        return SuccessResponse.ok(ArticleResponse.from(articleDetail));
    }
}
