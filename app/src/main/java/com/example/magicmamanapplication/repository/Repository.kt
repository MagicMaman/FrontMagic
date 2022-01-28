package com.example.magicmamanapplication.repository

import com.example.magicmamanapplication.Retrofit.RetrofitInstance
import com.example.magicmamanapplication.data.*
import retrofit2.Response

class Repository {

    suspend fun getCustomtete(userId: Int, sort: String, order: String): Response<List<teteItem>> {
        return RetrofitInstance.api.gettete(userId, sort, order)
    }

    suspend fun getCustomsolide(userId: Int, sort: String, order: String): Response<List<SolideItem>> {
        return RetrofitInstance.api.getsolide(userId, sort, order)
    }

    suspend fun getCustombibron(userId: Int, sort: String, order: String): Response<List<BibronItem>> {
        return RetrofitInstance.api.getbibron(userId, sort, order)
    }

    suspend fun getCustomsommeil(userId: Int, sort: String, order: String): Response<List<SommeilItem>> {
        return RetrofitInstance.api.getsommeil(userId, sort, order)
    }

    suspend fun getCustomtaille(userId: Int, sort: String, order: String): Response<List<TailleItem>> {
        return RetrofitInstance.api.gettaille(userId, sort, order)
    }

    suspend fun getCustompoids(userId: Int, sort: String, order: String): Response<List<PoidsItem>> {
        return RetrofitInstance.api.getpoids(userId, sort, order)
    }

    suspend fun getCustomvaccin(userId: Int, sort: String, order: String): Response<List<VaccinItem>> {
        return RetrofitInstance.api.getvaccin(userId, sort, order)
    }

    suspend fun getCustommedicament(userId: Int, sort: String, order: String): Response<List<MedicamentItem>> {
        return RetrofitInstance.api.getmedicament(userId, sort, order)
    }

    suspend fun getCustomtemperature(userId: Int, sort: String, order: String): Response<List<TemperatureItem>> {
        return RetrofitInstance.api.gettemperature(userId, sort, order)
    }
    suspend fun addbaby(str: String,str2: String,str3: String,str4: String,str5: String) {
        return RetrofitInstance.api.Identifyy(str,str2,str3,str4,str5)


    }


    suspend fun addtete(str: String,str2: String,str3: String) {
        return RetrofitInstance.api.ajoutTete(str,str2,str3)


    }

    suspend fun addsolide(str: String,str2: String,str3: String,str4: String) {
        return RetrofitInstance.api.ajoutSolide(str,str2,str3,str4)


    }
    suspend fun addbibron(str: String,str2: String,str3: String,str4: String) {
        return RetrofitInstance.api.ajoutBibron(str,str2,str3,str4)


    }

    suspend fun addsommeil(str: String,str2: String,str3: String,str4: String) {
        return RetrofitInstance.api.ajoutSommeil(str,str2,str3,str4)


    }

    suspend fun addtaille(str: String,str2: String,str3: String,str4: String) {
        return RetrofitInstance.api.ajoutTaille(str,str2,str3,str4)


    }

    suspend fun addpoids(str: String,str2: String,str3: String,str4: String) {
        return RetrofitInstance.api.ajoutPoids(str,str2,str3,str4)


    }

    suspend fun addvaccin(str: String,str2: String,str3: String,str4: String) {
        return RetrofitInstance.api.ajoutVaccin(str,str2,str3,str4)


    }

    suspend fun addtemperature(str: String,str2: String,str3: String,str4: String) {
        return RetrofitInstance.api.ajoutTemperature(str,str2,str3,str4)


    }

    suspend fun addmedicament(str: String,str2: String,str3: String,str4: String,str5: String) {
        return RetrofitInstance.api.ajoutMedicament(str,str2,str3,str4,str5)


    }
}