package com.brivadigital.podplay.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.brivadigital.podplay.R
import com.brivadigital.podplay.databinding.FragmentPodcastDetailsBinding
import com.brivadigital.podplay.viewmodel.PodcastViewModel
import com.bumptech.glide.Glide

class PodcastDetailsFragment:Fragment() {
    private lateinit var dataBinding: FragmentPodcastDetailsBinding
    private val podcastViewModel: PodcastViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentPodcastDetailsBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Calling th update Controls Function
        updateControls()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_details, menu)
    }
    private fun updateControls(){
        val viewData = podcastViewModel.activePodcastViewData?:
        return
        dataBinding.feedTitleTextView.text = viewData.feedTitle
        dataBinding.feedDescTextView.text = viewData.feedDesc
        activity?.let {
            activity ->
            Glide.with(activity).load(viewData.imageUrl).into(dataBinding.feedImageView)
        }
    }

    companion object{
        fun newInstance(): PodcastDetailsFragment{
            return PodcastDetailsFragment()
        }
    }
}