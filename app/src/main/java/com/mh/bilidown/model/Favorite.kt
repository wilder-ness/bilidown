package com.mh.bilidown.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName ="favorite")
data class Favorite(
    @PrimaryKey
    val id: String,
    val title: String?,
    val isSeason: Boolean,
    val cover: String?
)