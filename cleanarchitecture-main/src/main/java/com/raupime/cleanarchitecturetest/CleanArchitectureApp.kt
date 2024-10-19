package com.raupime.cleanarchitecturetest

import android.app.Application
import com.raupime.cleanarchitecturetest.di.dataModule
import com.raupime.cleanarchitecturetest.di.domainModule
import com.raupime.cleanarchitecturetest.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.module

class CleanArchitectureApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CleanArchitectureApp)
            androidLogger()
            modules(dataModule, domainModule, presentationModule)
        }
    }
}