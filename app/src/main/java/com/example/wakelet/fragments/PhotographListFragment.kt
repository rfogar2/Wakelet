package com.example.wakelet.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
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

    override fun onResume() {
        super.onResume()

        activity?.setTitle(R.string.app_name)
    }

    private fun setupRefreshLayout() {
        refresh_layout.setOnRefreshListener(::getPhotographs)
    }

    private fun setupRecyclerView() {
        adapter = PhotographAdapter { photograph ->
            findNavController().navigate(PhotographListFragmentDirections.viewDetail(photograph))
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
                    Toast.makeText(context, R.string.An_error_occurred, Toast.LENGTH_LONG).show()
                })

        disposables.add(disposable)
    }
}