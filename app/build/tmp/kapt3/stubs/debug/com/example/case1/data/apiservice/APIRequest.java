package com.example.case1.data.apiservice;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/case1/data/apiservice/APIRequest;", "", "getNews", "Lretrofit2/Call;", "Lcom/example/case1/data/models/RequestDataModel;", "q", "", "from", "to", "sortBy", "apiKey", "app_debug"})
public abstract interface APIRequest {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "https://newsapi.org/v2/everything")
    public abstract retrofit2.Call<com.example.case1.data.models.RequestDataModel> getNews(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q")
    java.lang.String q, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "from")
    java.lang.String from, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "to")
    java.lang.String to, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "sortBy")
    java.lang.String sortBy, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apiKey")
    java.lang.String apiKey);
}