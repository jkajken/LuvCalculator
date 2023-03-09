package com.jk.luvcalculator.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jk.luvcalculator.model.LoveModel

@Dao
interface LoveDao {
    @Insert
    fun insertLove(loveModel: LoveModel)

    @Query("SELECT * FROM love_model")
    fun getAll(): LiveData<List<LoveModel>>

    @Query("SELECT * FROM love_model ORDER BY firstName ASC")
    fun getAllByAlphabet(): List<LoveModel>
}