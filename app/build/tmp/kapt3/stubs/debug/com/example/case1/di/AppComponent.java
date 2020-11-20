package com.example.case1.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/case1/di/AppComponent;", "Ldagger/android/AndroidInjector;", "Lcom/example/case1/App;", "Factory", "app_debug"})
@dagger.Component(modules = {com.example.case1.data.di.NetworkModule.class, com.example.case1.di.AppModule.class, dagger.android.support.AndroidSupportInjectionModule.class, dagger.android.AndroidInjectionModule.class, com.example.case1.di.ViewModelModule.class, com.example.case1.di.ActivityBindingModule.class})
@javax.inject.Singleton()
public abstract interface AppComponent extends dagger.android.AndroidInjector<com.example.case1.App> {
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/case1/di/AppComponent$Factory;", "", "create", "Lcom/example/case1/di/AppComponent;", "app", "Lcom/example/case1/App;", "app_debug"})
    @dagger.Component.Factory()
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.example.case1.di.AppComponent create(@org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        com.example.case1.App app);
    }
}