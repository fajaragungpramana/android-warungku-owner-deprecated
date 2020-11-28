package com.implizstudio.android.app.warungkuowner.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.databinding.FragmentHomeBinding
import com.implizstudio.android.app.warungkuowner.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel by viewModels<HomeViewModel>()

    override fun getContentView() = R.layout.fragment_home

    override fun onCreated(savedInstanceState: Bundle?) {

    }

}