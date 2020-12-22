package com.example.case1.data.backup.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.case1.data.backup.model.ArticleEntity

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article_table")
    fun getAllArticles(): List<ArticleEntity>

    @Insert
    fun insertAll(reportEntityList: ArticleEntity)

    @Query("DELETE FROM article_table")
    fun deleteAll()
}