package com.example.wakelet.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.wakelet.R
import kotlinx.android.synthetic.main.fragment_photograph_detail.*

class PhotographDetailFragment : Fragment() {

    private val args by navArgs<PhotographDetailFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_photograph_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(image.context)
            .load(args.photograph.image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(image)

        description.text = args.photograph.description
        name.text = args.photograph.name
        bio.text = args.photograph.bio
    }

    override fun onResume() {
        super.onResume()

        activity?.title = args.photograph.name
    }
}