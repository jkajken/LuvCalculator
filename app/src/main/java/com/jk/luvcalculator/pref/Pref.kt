package com.jk.luvcalculator.pref

import android.content.Context
import android.content.SharedPreferences

class Pref{
     lateinit var pref: SharedPreferences


    fun  onPref(context: Context){ pref = context.getSharedPreferences("unique_name",
        Context.MODE_PRIVATE
    )}

    fun isOnBoardingShown(): Boolean {
        return pref.getBoolean(BOARDING_SHOW, false)
    }

    fun saveShowBoarding(isShow: Boolean) {
        pref.edit().putBoolean(BOARDING_SHOW, isShow).apply()
    }
    companion object {
        private const val BOARDING_SHOW = "boarding.show"

    }
}