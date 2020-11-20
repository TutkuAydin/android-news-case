package com.example.case1.data.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u00a2\u0006\u0002\u0010\nR*\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/example/case1/data/models/RequestDataModel;", "", "status", "", "totalResults", "", "reports", "Ljava/util/ArrayList;", "Lcom/example/case1/data/models/ArticleDataModel;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;ILjava/util/ArrayList;)V", "getReports", "()Ljava/util/ArrayList;", "getStatus", "()Ljava/lang/String;", "getTotalResults", "()I", "app_debug"})
public final class RequestDataModel {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "status")
    private final java.lang.String status = null;
    @com.google.gson.annotations.SerializedName(value = "totalResults")
    private final int totalResults = 0;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "articles")
    private final java.util.ArrayList<com.example.case1.data.models.ArticleDataModel> reports = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final int getTotalResults() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.example.case1.data.models.ArticleDataModel> getReports() {
        return null;
    }
    
    public RequestDataModel(@org.jetbrains.annotations.NotNull()
    java.lang.String status, int totalResults, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.example.case1.data.models.ArticleDataModel> reports) {
        super();
    }
}