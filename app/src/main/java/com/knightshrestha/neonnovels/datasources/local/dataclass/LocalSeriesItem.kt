package com.knightshrestha.neonnovels.datasources.local.dataclass

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Entity(tableName = "Series Items")
@Parcelize
data class LocalSeriesItem(
    @PrimaryKey(autoGenerate = true) var seriesID: Int = 0,
    var title: String,
    @SerializedName("updated_at") var updatedAt: Long? = 0,
    @SerializedName("created_at") var createdAt: Long? = 0,
    var thumbnail: String? = null,
    var synopsis: String? = null,
    var genres: List<String>? = null,
    var download: String? = null,
    var author: String? = null,
    var alias: List<String>? = null
): Parcelable