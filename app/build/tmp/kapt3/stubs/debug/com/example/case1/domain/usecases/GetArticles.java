package com.example.case1.domain.usecases;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/case1/domain/usecases/GetArticles;", "Lcom/example/case1/domain/usecases/BaseUseCase;", "Lcom/example/case1/domain/models/Article;", "apiRepo", "Lcom/example/case1/domain/repositories/Repo;", "(Lcom/example/case1/domain/repositories/Repo;)V", "execute", "", "from", "", "to", "app_debug"})
public final class GetArticles implements com.example.case1.domain.usecases.BaseUseCase<com.example.case1.domain.models.Article> {
    private final com.example.case1.domain.repositories.Repo apiRepo = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<com.example.case1.domain.models.Article> execute(@org.jetbrains.annotations.NotNull()
    java.lang.String from, @org.jetbrains.annotations.NotNull()
    java.lang.String to) {
        return null;
    }
    
    @javax.inject.Inject()
    public GetArticles(@org.jetbrains.annotations.NotNull()
    com.example.case1.domain.repositories.Repo apiRepo) {
        super();
    }
}