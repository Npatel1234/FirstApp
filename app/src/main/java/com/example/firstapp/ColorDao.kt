package com.example.firstapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface ColorDao {

    @Query("select*from color")
    suspend fun getAll(): Array<Color>

    @Insert
   suspend fun insert(vararg color: Color)
}