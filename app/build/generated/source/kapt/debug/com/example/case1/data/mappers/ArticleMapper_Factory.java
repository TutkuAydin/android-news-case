// Generated by Dagger (https://dagger.dev).
package com.example.case1.data.mappers;

import dagger.internal.Factory;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ArticleMapper_Factory implements Factory<ArticleMapper> {
  @Override
  public ArticleMapper get() {
    return newInstance();
  }

  public static ArticleMapper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ArticleMapper newInstance() {
    return new ArticleMapper();
  }

  private static final class InstanceHolder {
    private static final ArticleMapper_Factory INSTANCE = new ArticleMapper_Factory();
  }
}