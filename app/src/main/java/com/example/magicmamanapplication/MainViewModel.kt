package com.example.magicmamanapplication


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magicmamanapplication.data.BibronItem
import com.example.magicmamanapplication.data.SolideItem
import com.example.magicmamanapplication.data.SommeilItem
import com.example.magicmamanapplication.data.teteItem
import com.example.magicmamanapplication.repository.Repository
import kotlinx.coroutines.launch

import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myCustomTete: MutableLiveData<Response<List<teteItem>>> = MutableLiveData()
    var myCustomSolide: MutableLiveData<Response<List<SolideItem>>> = MutableLiveData()
    var myCustomBibron: MutableLiveData<Response<List<BibronItem>>> = MutableLiveData()
    var myCustomSommeil: MutableLiveData<Response<List<SommeilItem>>> = MutableLiveData()


    fun getCustomTete(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomtete(userId, sort, order)
            myCustomTete.value = response
        }
    }

    fun getCustomSolide(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomsolide(userId, sort, order)
            myCustomSolide.value = response
        }
    }

    fun myCustomBibron(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustombibron(userId, sort, order)
            myCustomBibron.value = response
        }
    }

    fun myCustomSommeil(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomsommeil(userId, sort, order)
            myCustomSommeil.value = response
        }
    }


}