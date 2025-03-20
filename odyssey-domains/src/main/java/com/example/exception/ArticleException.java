package com.example.exception;

public enum ArticleException implements BusinessError {
    NOT_FOUND_ERROR{
        @Override
        public int getHttpStatus() {
            return 404;
        }

        @Override
        public String getErrorCode() {
            return "ARTICLE-001";
        }

        @Override
        public String getClientMessage() {
            return "조회된 게시글이 없습니다.";
        }

        @Override
        public String getLogMessage() {
            return "not found article";
        }
    }
    ;
}
