package com.example.wakelet.dagger.modules

import com.example.wakelet.fragments.PhotographDetailFragment
import com.example.wakelet.fragments.PhotographListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
@Suppress("unused")
abstract class FragmentInjectorsModule {

    @ContributesAndroidInjector
    abstract fun photographListFragment(): PhotographListFragment

    @ContributesAndroidInjector
    abstract fun photographDetailFragment(): PhotographDetailFragment
}
