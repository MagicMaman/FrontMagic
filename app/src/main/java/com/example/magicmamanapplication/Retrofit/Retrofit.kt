package com.example.magicmamanapplication.Retrofit

import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class Retrofit {
    var BASE_URL = "http://192.168.1.16:3000/" // Localhost will be changed to 10.0.2.2 in Emulator

    fun getRetroClinetInstance() : Retrofit{

        val gson = GsonBuilder().setLenient().create()
        //return Retrofit builder
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }
}