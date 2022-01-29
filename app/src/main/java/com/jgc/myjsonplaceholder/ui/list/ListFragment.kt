package com.jgc.myjsonplaceholder.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.jgc.myjsonplaceholder.R
import com.jgc.myjsonplaceholder.databinding.FragmentListBinding
import com.jgc.myjsonplaceholder.ui.base.BaseFragment
import com.jgc.myjsonplaceholder.ui.list.adapter.PostAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment @Inject constructor() : BaseFragment<ListFragmentViewModel>() {

    private lateinit var binding: FragmentListBinding
    private val localViewModel: ListFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list,
            container,
            false
        )

        binding.apply {
            viewModel = localViewModel
            lifecycleOwner = viewLifecycleOwner
            adapter = PostAdapter(listOf(), localViewModel)
        }

        return binding.root
    }

    override fun getViewModel(): ListFragmentViewModel = localViewModel
}