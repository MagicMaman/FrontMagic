package com.example.magicmamanapplication.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    var BASE_URL = "http://192.168.43.115:3000/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: MagicMamanApi by lazy {
        retrofit.create(MagicMamanApi::class.java)
    }

}