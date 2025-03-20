package com.example.domain.article;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class ArticleTest {

    @Test
    void 가장_최신의_snapShot_을_조회한다() {
        // given
        final var article = Article.builder().build();

        final var articleSnapShotLasted = ArticleSnapShot.create("제목1", "내용1", article);
        final var articleSnapShot1 = ArticleSnapShot.create("제목2", "내용2", article);
        final var articleSnapShot2 = ArticleSnapShot.create("제목3", "내용3", article);

        setFieldValue(articleSnapShotLasted, "createdAt", LocalDateTime.now());
        setFieldValue(articleSnapShot1, "createdAt", LocalDateTime.now().minusDays(1L));
        setFieldValue(articleSnapShot2, "createdAt", LocalDateTime.now().minusDays(2L));

        article.addSnapshot(articleSnapShotLasted);
        article.addSnapshot(articleSnapShot1);
        article.addSnapshot(articleSnapShot2);

        // when
        final var actual = article.getLastedArticle();

        // then
        assertThat(actual).isEqualTo(articleSnapShotLasted);
    }


    void setFieldValue(Object target, String fieldName, Object value) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to set field value: " + fieldName, e);
        }
    }
}