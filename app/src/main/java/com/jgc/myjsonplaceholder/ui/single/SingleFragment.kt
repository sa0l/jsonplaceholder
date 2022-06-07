package com.jgc.myjsonplaceholder.ui.single

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jgc.myjsonplaceholder.POST_ID
import com.jgc.myjsonplaceholder.R
import com.jgc.myjsonplaceholder.databinding.FragmentSingleBinding
import com.jgc.myjsonplaceholder.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleFragment : BaseFragment<SingleFragmentViewModel>() {

    private var binding: FragmentSingleBinding? = null
    private val localViewModel: SingleFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        localViewModel.onPostIdReceived(arguments?.getString(POST_ID))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_single,
            container,
            false
        )

        return binding?.apply {
            viewModel = localViewModel
            lifecycleOwner = viewLifecycleOwner

        }?.root
    }

    override fun onResume() {
        super.onResume()
        localViewModel.requestedNavigation.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun getViewModel(): SingleFragmentViewModel = localViewModel
}