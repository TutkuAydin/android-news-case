package com.example.case1.data.models

import com.google.gson.annotations.SerializedName

class SourceDataModel(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?
)