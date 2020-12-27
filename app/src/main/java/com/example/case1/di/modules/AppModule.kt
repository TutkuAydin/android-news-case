package com.example.case1.di.modules

import android.content.Context
import androidx.room.Room
import com.example.case1.data.backup.dao.ArticleDao
import com.example.case1.data.backup.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideArticleDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context, AppDatabase::class.java,
            AppDatabase.getDatabase(context).toString()
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideArticleDAO(articleDatabase: AppDatabase): ArticleDao {
        return articleDatabase.articleDao()
    }
}
