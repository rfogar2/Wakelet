package com.example.wakelet.dagger.modules

import com.example.wakelet.WakeletApplication
import com.example.wakelet.wrappers.ResourcesWrapper
import com.example.wakelet.wrappers.ResourcesWrapperImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: WakeletApplication) {
    @Provides
    @Singleton
    fun provideResourcesWrapper(): ResourcesWrapper = ResourcesWrapperImpl(app.resources)
}
