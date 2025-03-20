package com.example.domain.article;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArticleCustomRepositoryImpl implements ArticleCustomRepository {

    private static final QArticle a = QArticle.article;
    private static final QArticleSnapShot as = QArticleSnapShot.articleSnapShot;

    private final JPAQueryFactory queryFactory;

    // TODO: JPA 랑 쿼리 비교
    @Override
    public Optional<ArticleDetail> findLatestArticle(final Long id) {
        return Optional.ofNullable(
                queryFactory
                        .select(new QArticleDetail(
                                a.id,
                                as.title,
                                as.content,
                                a.createdAt,
                                as.createdAt
                        ))
                        .from(a)
                        .join(as).on(a.id.eq(as.id))
                        .where(a.deletedAt.isNull())
                        .orderBy(a.createdAt.desc())
                        .fetchFirst()
        );
    }
}
