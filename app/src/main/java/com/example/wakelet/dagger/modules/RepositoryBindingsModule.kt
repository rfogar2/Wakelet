package com.example.wakelet.dagger.modules

import com.example.wakelet.repositories.PhotographRepository
import com.example.wakelet.repositories.PhotographRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBindingsModule {
    @Binds
    abstract fun photographRepository(impl: PhotographRepositoryImpl): PhotographRepository
}