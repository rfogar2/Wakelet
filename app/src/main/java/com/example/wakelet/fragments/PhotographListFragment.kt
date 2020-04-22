package com.example.wakelet.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wakelet.R
import com.example.wakelet.adapters.PhotographAdapter
import com.example.wakelet.usecases.GetPhotographsUseCase
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_photograph_list.*
import javax.inject.Inject

class PhotographListFragment : BaseFragment() {
    private lateinit var getPhotographsUseCase: GetPhotographsUseCase

    private var adapter: PhotographAdapter
        get() = photograph_recycler_view.adapter as PhotographAdapter
        set(value) {
            photograph_recycler_view.adapter = value
        }

    @Inject
    fun inject(getPhotographsUseCase: GetPhotographsUseCase) {
        this.getPhotographsUseCase = getPhotographsUseCase
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photograph_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRefreshLayout()
        setupRecyclerView()
        getPhotographs()
    }

    private fun setupRefreshLayout() {
        refresh_layout.setOnRefreshListener(::getPhotographs)
    }

    private fun setupRecyclerView() {
        adapter = PhotographAdapter { photograph ->
            // todo: open detail view
        }
    }

    private fun getPhotographs() {
        refresh_layout.isRefreshing = true

        val disposable = getPhotographsUseCase.invoke()
            .doAfterTerminate { refresh_layout.isRefreshing = false }
            .subscribeOn(Schedulers.io())
            .subscribe(
                { photographs ->
                    adapter.submitList(photographs)
                },
                {
                    // todo: handle errors
                })

        disposables.add(disposable)
    }
}