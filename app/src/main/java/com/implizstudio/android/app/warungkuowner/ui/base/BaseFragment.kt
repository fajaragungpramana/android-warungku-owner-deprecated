package com.implizstudio.android.app.warungkuowner.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    private lateinit var viewDataBinding: T

    abstract fun getContentView(): Int

    abstract fun onCreated(savedInstanceState: Bundle?)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate<T>(
            LayoutInflater.from(activity),
            getContentView(),
            container,
            false
        ).apply { lifecycleOwner = viewLifecycleOwner }
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        onCreated(savedInstanceState)

    }

}