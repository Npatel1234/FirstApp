package com.example.firstapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "color")
data class Color (
    @PrimaryKey(autoGenerate = true)
    val id:Int ,
    @ColumnInfo(name = "hax_color")
    val hex: String,

    val name: String


)