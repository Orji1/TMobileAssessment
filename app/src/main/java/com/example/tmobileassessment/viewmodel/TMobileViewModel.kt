package com.example.tmobileassessment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmobileassessment.model.repository.IRepository
import com.example.tmobileassessment.model.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TMobileViewModel(private val repository: IRepository) : ViewModel() {
    private val mutableLiveData = MutableLiveData<Repository.DataState>()
    val liveData: LiveData<Repository.DataState> = mutableLiveData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getResponse()
            withContext(Dispatchers.Main) {
                mutableLiveData.value = Repository.DataState.Loading
                mutableLiveData.value = data
            }
        }
    }
}