package com.example.magicmamanapplication.Retrofit

import com.example.magicmamanapplication.data.*
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

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

    @GET("/bibron/")
    suspend fun getbibron(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<BibronItem>>

    @GET("/endormissement/")
    suspend fun getsommeil(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<SommeilItem>>

    @GET("/taille/")
    suspend fun gettaille(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<TailleItem>>

    @GET("/poids/")
    suspend fun getpoids(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<PoidsItem>>

    @GET("/temperature/")
    suspend fun gettemperature(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<TemperatureItem>>

    @GET("/medicament/")
    suspend fun getmedicament(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<MedicamentItem>>

    @GET("/vaccin/")
    suspend fun getvaccin(
        @Query("userId") Id: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<VaccinItem>>

//http://localhost:3000/baby/storee/malek@azer.com/pere/ayadi/12-12-1999/male
    @GET("/baby/storee/{email}/{liaison}/{prenom}/{annif}/{gendre}")
    suspend fun Identifyy(
    @Path("email") email:String,
    @Path("liaison") liaison:String,
    @Path("prenom") prenom:String,
    @Path("annif") annif:String,
    @Path("gendre") gendre:String
)

}