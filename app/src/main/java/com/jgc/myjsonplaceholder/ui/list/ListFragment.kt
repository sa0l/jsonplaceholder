package com.jgc.myjsonplaceholder.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jgc.myjsonplaceholder.R
import com.jgc.myjsonplaceholder.databinding.FragmentListBinding
import com.jgc.myjsonplaceholder.domain.models.Post
import com.jgc.myjsonplaceholder.ui.base.BaseFragment
import com.jgc.myjsonplaceholder.ui.list.adapter.PostAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment @Inject constructor() : BaseFragment<ListFragmentViewModel>(),
    PostAdapter.OnItemClickListener {

    private var binding: FragmentListBinding? = null
    private val localViewModel: ListFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list,
            container,
            false
        )

        return binding?.apply {
            viewModel = localViewModel
            lifecycleOwner = viewLifecycleOwner
            adapter = PostAdapter(itemClickListener = this@ListFragment)
        }?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun getViewModel(): ListFragmentViewModel = localViewModel

    override fun onItemDetailsClick(post: Post) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToSingleFragment(post.id.toString()))
    }
}