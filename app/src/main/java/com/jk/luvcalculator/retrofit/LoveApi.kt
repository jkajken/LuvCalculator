package com.jk.luvcalculator.retrofit

import com.jk.luvcalculator.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getLoveResult(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key")key: String="1c6b7ccb5fmshdc2a45156361540p157e95jsn704c20539f0d",
        @Header("X-RapidAPI-Host")host: String="love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}