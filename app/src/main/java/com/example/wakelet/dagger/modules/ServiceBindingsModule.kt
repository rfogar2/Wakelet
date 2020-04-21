package com.example.wakelet.dagger.modules

import com.example.wakelet.services.PhotographService
import com.example.wakelet.services.PhotographServiceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ServiceBindingsModule {
    @Binds
    abstract fun photographService(impl: PhotographServiceImpl): PhotographService
}