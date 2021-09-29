package com.example.tmobileassessment.di.modules

import com.example.tmobileassessment.model.repository.IRepository
import com.example.tmobileassessment.model.repository.Repository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun providesRepository(): IRepository {
        return Repository()
    }
}