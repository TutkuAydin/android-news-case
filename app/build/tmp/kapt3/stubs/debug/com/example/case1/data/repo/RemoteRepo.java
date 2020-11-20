package com.example.case1.data.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/case1/data/repo/RemoteRepo;", "Lcom/example/case1/domain/repositories/Repo;", "apiService", "Lcom/example/case1/data/apiservice/APIRequest;", "articleMapper", "Ldagger/Lazy;", "Lcom/example/case1/data/mappers/ArticleMapper;", "(Lcom/example/case1/data/apiservice/APIRequest;Ldagger/Lazy;)V", "apiKey", "", "keyword", "sortBy", "getArticles", "", "Lcom/example/case1/domain/models/Article;", "from", "to", "app_debug"})
public final class RemoteRepo implements com.example.case1.domain.repositories.Repo {
    private final java.lang.String keyword = "football";
    private final java.lang.String sortBy = "publishedAt";
    private final java.lang.String apiKey = "ae68088e70d04639b4950bdc9d546924";
    private final com.example.case1.data.apiservice.APIRequest apiService = null;
    private final dagger.Lazy<com.example.case1.data.mappers.ArticleMapper> articleMapper = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.example.case1.domain.models.Article> getArticles(@org.jetbrains.annotations.NotNull()
    java.lang.String from, @org.jetbrains.annotations.NotNull()
    java.lang.String to) {
        return null;
    }
    
    @javax.inject.Inject()
    public RemoteRepo(@org.jetbrains.annotations.NotNull()
    com.example.case1.data.apiservice.APIRequest apiService, @org.jetbrains.annotations.NotNull()
    dagger.Lazy<com.example.case1.data.mappers.ArticleMapper> articleMapper) {
        super();
    }
}