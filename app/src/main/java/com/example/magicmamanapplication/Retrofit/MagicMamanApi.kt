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

//router.get('/storee/:babyy/:timee/:notess',teteController.store)
    //http://localhost:3000/baby/storee/malek@azer.com/pere/ayadi/12-12-1999/male
    @GET("/tete/storee/{babyy}/{timee}/{notess}")
    suspend fun ajoutTete(
        @Path("babyy") babyy:String,
        @Path("timee") timee:String,
        @Path("notess") notess:String
    )



    //http://localhost:3000/solide/storee/malek/13/azert/124
    //router.get('/storee/:babyy/:timee/:namee/:notess',solideController.storee)
    @GET("/solide/storee/{babyy}/{timee}/{namee}/{notess}")
    suspend fun ajoutSolide(
        @Path("babyy") babyy:String,
        @Path("timee") timee:String,
        @Path("namee") namee:String,
        @Path("notess") notess:String
    )

    //http://localhost:3000/solide/storee/malek/13/azert/124
    //router.get('/storee/:babyy/:timee/:quantityy/:notess',bibronController.storee)
    @GET("/bibron/storee/{babyy}/{timee}/{quantityy}/{notess}")
    suspend fun ajoutBibron(
        @Path("babyy") babyy:String,
        @Path("timee") timee:String,
        @Path("quantityy") quantityy:String,
        @Path("notess") notess:String
    )

    //http://localhost:3000/solide/storee/malek/13/azert/124
    //router.get('/storee/:babyy/:timesleepp/:timeawakee/:notess',endormissementController.storee)
    @GET("/endormissement/storee/{babyy}/{timesleepp}/{timeawakee}/{notess}")
    suspend fun ajoutSommeil(
        @Path("babyy") babyy:String,
        @Path("timesleepp") timesleepp:String,
        @Path("timeawakee") timeawakee:String,
        @Path("notess") notess:String
    )

    //http://localhost:3000/solide/storee/malek/13/azert/124
    //router.get('/storee/:babyy/:timee/:taillee/:notess',tailleController.store)
    @GET("/taille/storee/{babyy}/{timee}/{taillee}/{notess}")
    suspend fun ajoutTaille(
        @Path("babyy") babyy:String,
        @Path("timee") timee:String,
        @Path("taillee") taillee:String,
        @Path("notess") notess:String
    )

    //http://localhost:3000/solide/storee/malek/13/azert/124
    //router.get('/storee/:babyy/:timee/:poidss/:notess',poidsController.storee)
    @GET("/poids/storee/{babyy}/{timee}/{poidss}/{notess}")
    suspend fun ajoutPoids(
        @Path("babyy") babyy:String,
        @Path("timee") timee:String,
        @Path("poidss") poidss:String,
        @Path("notess") notess:String
    )

    //http://localhost:3000/solide/storee/malek/13/azert/124
    //router.get('/storee/:babyy/:timee/:namee/:notess',vaccinController.storee)
    @GET("/vaccin/storee/{babyy}/{timee}/{namee}/{notess}")
    suspend fun ajoutVaccin(
        @Path("babyy") babyy:String,
        @Path("timee") timee:String,
        @Path("namee") namee:String,
        @Path("notess") notess:String
    )

    //http://localhost:3000/solide/storee/malek/13/azert/124
    //router.get('/storee/:babyy/:timee/:temperaturee/:notess',temperatureController.storee)
    @GET("/temperature/storee/{babyy}/{timee}/{temperaturee}/{notess}")
    suspend fun ajoutTemperature(
        @Path("babyy") babyy:String,
        @Path("timee") timee:String,
        @Path("temperaturee") temperaturee:String,
        @Path("notess") notess:String
    )

    //http://localhost:3000/solide/storee/malek/13/azert/124
    //router.get('/storee/:babyy/:timee/:namee/:quantityy/:notee',medicamentController.storee)
    @GET("/medicament/storee/{babyy}/{timee}/{namee}/{quantityy}/{notess}")
    suspend fun ajoutMedicament(
        @Path("babyy") babyy:String,
        @Path("timee") timee:String,
        @Path("namee") temperaturee:String,
        @Path("quantityy") quantityy:String,
        @Path("notess") notess:String
    )
}