package com.Abdul.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "User_table",
//    foreignKeys = [ForeignKey(
//        entity = CountryDB::class,
//        parentColumns = ["id"],
//        childColumns = ["id_country"]
//    )]
)
data class UserDB(
    @PrimaryKey(autoGenerate = true)
    val userId: Int,
    @SerializedName("nationality")
    val FIO: String = "",
    val id_country: Int = 1,
    @SerializedName("language")
    val spesialnost: String = "",
    @SerializedName("national_sport")
    val opisanie: String = "",
    @SerializedName("flag")
    val image: String = ""
)

@Entity(tableName = "country")
data class CountryDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)


