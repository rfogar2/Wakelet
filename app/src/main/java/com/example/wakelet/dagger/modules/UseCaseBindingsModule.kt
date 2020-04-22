package com.example.wakelet.dagger.modules

import com.example.wakelet.usecases.GetPhotographsUseCase
import com.example.wakelet.usecases.GetPhotographsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseBindingsModule {
    @Binds
    abstract fun getPhotographsUseCase(impl: GetPhotographsUseCaseImpl): GetPhotographsUseCase
}