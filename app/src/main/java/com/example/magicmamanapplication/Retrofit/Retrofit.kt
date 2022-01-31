package com.example.magicmamanapplication.Retrofit

import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class Retrofit {
    var BASE_URL = "https://magicmaman.herokuapp.com/"
    //var BASE_URL = "http://192.168.1.25:3000/"

    fun getRetroClinetInstance() : Retrofit{

        val gson = GsonBuilder().setLenient().create()
        //return Retrofit builder
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }
}