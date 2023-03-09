package com.jk.luvcalculator.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.jk.luvcalculator.model.LoveModel
import com.jk.luvcalculator.remote.LoveApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val getLoveApi: LoveApi) {

    fun getLove(firstName:String,secondName:String):MutableLiveData<LoveModel>{
        val liveLoveData = MutableLiveData<LoveModel>()
        getLoveApi.getLoveResult(firstName,secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    liveLoveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
            Log.d("niki","onFailure: ${t.message}")
            }
        })
        return liveLoveData
    }
}