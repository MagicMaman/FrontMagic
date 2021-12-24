package com.example.magicmamanapplication.Retrofit

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MagicMamanApi {
    @POST("/signin")
    fun login(@Body body: JsonObject): Call<JsonObject>

    @POST("/signup")
    fun SignUp(@Body body: JsonObject): Call<JsonObject>

    @POST("/baby/store")
    fun store (@Body body: JsonObject): Call<JsonObject>


    /*@POST("/show")
    fun showUser(@Body body: JsonObject): Call<JsonObject>

    @POST("/update")
    fun updateUser(@Body body: JsonObject): Call<JsonObject>*/
}