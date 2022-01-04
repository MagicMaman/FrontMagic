package com.example.magicmamanapplication.repository

import com.example.magicmamanapplication.Retrofit.RetrofitInstance
import com.example.magicmamanapplication.data.BibronItem
import com.example.magicmamanapplication.data.SolideItem
import com.example.magicmamanapplication.data.teteItem
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

}