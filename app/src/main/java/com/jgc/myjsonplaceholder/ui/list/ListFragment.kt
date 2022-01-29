package com.jgc.myjsonplaceholder.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.jgc.myjsonplaceholder.R
import com.jgc.myjsonplaceholder.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment @Inject constructor() : BaseFragment<ListFragmentViewModel>() {

    private val localViewModel: ListFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun getViewModel(): ListFragmentViewModel = localViewModel
}