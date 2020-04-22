package com.example.wakelet.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : Fragment() {
    protected val disposables = CompositeDisposable()

    override fun onDetach() {
        super.onDetach()

        disposables.clear()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}