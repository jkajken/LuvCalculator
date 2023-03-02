package com.jk.luvcalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jk.luvcalculator.model.LoveModel
import com.jk.luvcalculator.repository.Repository

class LoveViewModel:ViewModel() {

    private val repository = Repository()
    fun getLiveLove(firstName:String,secondName:String): LiveData<LoveModel>{
        return repository.getLove(firstName, secondName)
    }
}