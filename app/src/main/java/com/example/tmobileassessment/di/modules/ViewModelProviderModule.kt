package com.example.tmobileassessment.di.modules

import com.example.tmobileassessment.model.repository.IRepository
import com.example.tmobileassessment.viewmodel.TMobileViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class ViewModelProviderModule {
    @Provides
    fun provideViewModelProvider(repository: IRepository): TMobileViewModelProvider {
        return TMobileViewModelProvider(repository)
    }
}