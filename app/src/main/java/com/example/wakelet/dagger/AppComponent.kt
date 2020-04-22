package com.example.wakelet.dagger

import com.example.wakelet.WakeletApplication
import com.example.wakelet.dagger.modules.AppModule
import com.example.wakelet.dagger.modules.RepositoryBindingsModule
import com.example.wakelet.dagger.modules.ServiceBindingsModule
import com.example.wakelet.dagger.modules.UseCaseBindingsModule
import dagger.Component
import javax.inject.Singleton
import dagger.android.AndroidInjectionModule

@Singleton
@Component(modules = [
    ServiceBindingsModule::class,
    AndroidInjectionModule::class,
    AppModule::class,
    RepositoryBindingsModule::class,
    UseCaseBindingsModule::class
])
interface AppComponent {
    fun inject(application: WakeletApplication)
}