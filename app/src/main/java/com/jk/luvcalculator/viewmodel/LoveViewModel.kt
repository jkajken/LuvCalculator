package com.jk.luvcalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jk.luvcalculator.model.LoveModel
import com.jk.luvcalculator.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository):ViewModel() {

    fun getLiveLove(firstName:String,secondName:String): LiveData<LoveModel>{
        return repository.getLove(firstName, secondName)
    }
}