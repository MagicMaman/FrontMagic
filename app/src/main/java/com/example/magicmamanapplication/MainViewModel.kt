package com.example.magicmamanapplication


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magicmamanapplication.data.SolideItem
import com.example.magicmamanapplication.data.teteItem
import com.example.magicmamanapplication.repository.Repository
import kotlinx.coroutines.launch

import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myCustomTete: MutableLiveData<Response<List<teteItem>>> = MutableLiveData()
    var myCustomSolide: MutableLiveData<Response<List<SolideItem>>> = MutableLiveData()


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

}