package com.jk.luvcalculator.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoveService {
    private val retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getLoveApi(): LoveApi = retrofit.create(LoveApi ::class.java)
}