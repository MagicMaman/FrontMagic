package com.example.magicmamanapplication


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.magicmamanapplication.data.*
import com.example.magicmamanapplication.repository.Repository
import kotlinx.coroutines.launch

import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myCustomTete: MutableLiveData<Response<List<teteItem>>> = MutableLiveData()
    var myCustomSolide: MutableLiveData<Response<List<SolideItem>>> = MutableLiveData()
    var myCustomBibron: MutableLiveData<Response<List<BibronItem>>> = MutableLiveData()
    var myCustomSommeil: MutableLiveData<Response<List<SommeilItem>>> = MutableLiveData()
    var myCustomTaille: MutableLiveData<Response<List<TailleItem>>> = MutableLiveData()
    var myCustomPoids: MutableLiveData<Response<List<PoidsItem>>> = MutableLiveData()
    var myCustomTemperature: MutableLiveData<Response<List<TemperatureItem>>> = MutableLiveData()
    var myCustomVaccin: MutableLiveData<Response<List<VaccinItem>>> = MutableLiveData()
    var myCustomMedicament: MutableLiveData<Response<List<MedicamentItem>>> = MutableLiveData()


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

    fun myCustomTaille(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomtaille(userId, sort, order)
            myCustomTaille.value = response
        }
    }

    fun myCustomPoids(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustompoids(userId, sort, order)
            myCustomPoids.value = response
        }
    }

    fun myCustomTemperature(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomtemperature(userId, sort, order)
            myCustomTemperature.value = response
        }
    }

    fun myCustomVaccin(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustomvaccin(userId, sort, order)
            myCustomVaccin.value = response
        }
    }

    fun myCustomMedicament(userId: Int, sort: String, order: String) {
        viewModelScope.launch {
            val response = repository.getCustommedicament(userId, sort, order)
            myCustomMedicament.value = response
        }
    }

    fun addbaby(str: String,str2: String,str3: String,str4: String,str5: String){
        viewModelScope.launch {
            val response= repository.addbaby(str,str2,str3,str4,str5)
            //myResponse4.value=response
        }

    }


}