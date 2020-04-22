package com.example.wakelet.dagger

import com.example.wakelet.WakeletApplication
import com.example.wakelet.dagger.modules.*
import dagger.Component
import javax.inject.Singleton
import dagger.android.AndroidInjectionModule

@Singleton
@Component(modules = [
    ServiceBindingsModule::class,
    AndroidInjectionModule::class,
    AppModule::class,
    RepositoryBindingsModule::class,
    UseCaseBindingsModule::class,
    FragmentInjectorsModule::class
])
interface AppComponent {
    fun inject(application: WakeletApplication)
}