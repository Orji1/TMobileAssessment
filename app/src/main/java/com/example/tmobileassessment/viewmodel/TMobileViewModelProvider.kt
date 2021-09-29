package com.example.tmobileassessment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmobileassessment.model.repository.IRepository

class TMobileViewModelProvider(
    private val repository: IRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TMobileViewModel(repository) as T
    }
}