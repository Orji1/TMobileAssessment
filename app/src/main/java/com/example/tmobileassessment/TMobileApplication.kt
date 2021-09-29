package com.example.tmobileassessment

import android.app.Application
import com.example.tmobileassessment.di.component.DaggerTMobileComponent
import com.example.tmobileassessment.di.component.TMobileComponent
import com.example.tmobileassessment.di.modules.RepositoryModule
import com.example.tmobileassessment.di.modules.ViewModelProviderModule

class TMobileApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerTMobileComponent.builder()
            .repositoryModule(RepositoryModule())
            .viewModelProviderModule(ViewModelProviderModule())
            .build()
    }

    companion object {
        lateinit var component: TMobileComponent
    }
}