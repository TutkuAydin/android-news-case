// Generated by Dagger (https://dagger.dev).
package com.example.case1.domain.usecases;

import com.example.case1.domain.repositories.Repo;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GetArticles_Factory implements Factory<GetArticles> {
  private final Provider<Repo> apiRepoProvider;

  public GetArticles_Factory(Provider<Repo> apiRepoProvider) {
    this.apiRepoProvider = apiRepoProvider;
  }

  @Override
  public GetArticles get() {
    return newInstance(apiRepoProvider.get());
  }

  public static GetArticles_Factory create(Provider<Repo> apiRepoProvider) {
    return new GetArticles_Factory(apiRepoProvider);
  }

  public static GetArticles newInstance(Repo apiRepo) {
    return new GetArticles(apiRepo);
  }
}