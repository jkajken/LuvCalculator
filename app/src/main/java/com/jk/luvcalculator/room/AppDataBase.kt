package com.jk.luvcalculator.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jk.luvcalculator.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getDao(): LoveDao
}