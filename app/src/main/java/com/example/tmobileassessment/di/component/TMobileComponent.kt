package com.example.tmobileassessment.di.component

import com.example.tmobileassessment.MainActivity
import com.example.tmobileassessment.di.modules.RepositoryModule
import com.example.tmobileassessment.di.modules.ViewModelProviderModule
import dagger.Component

@Component(modules = [RepositoryModule::class, ViewModelProviderModule::class])
interface TMobileComponent {
    fun inject(activity: MainActivity)
}