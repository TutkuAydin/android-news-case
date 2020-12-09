package com.example.case1.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?
):Parcelable
