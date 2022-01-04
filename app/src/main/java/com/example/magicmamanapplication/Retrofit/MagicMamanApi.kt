package com.example.magicmamanapplication.Retrofit

import com.example.magicmamanapplication.data.SolideItem
import com.example.magicmamanapplication.data.teteItem
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MagicMamanApi {
    @POST("/signin")
    fun login(@Body body: JsonObject): Call<JsonObject>

    @POST("/signup")
    fun SignUp(@Body body: JsonObject): Call<JsonObject>

    @POST("/baby/store")
    fun store (@Body body: JsonObject): Call<JsonObject>

    @POST("/baby/update")
    fun updateUser(@Body body: JsonObject): Call<JsonObject>

    @GET("/tete/")
    suspend fun gettete(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<teteItem>>

    @GET("/solide/")
    suspend fun getsolide(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<SolideItem>>

}