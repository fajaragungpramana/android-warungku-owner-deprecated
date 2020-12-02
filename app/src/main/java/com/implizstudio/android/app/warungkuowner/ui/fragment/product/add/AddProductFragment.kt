package com.implizstudio.android.app.warungkuowner.ui.fragment.product.add

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.databinding.FragmentAddProductBinding
import com.implizstudio.android.app.warungkuowner.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_add_product.*

class AddProductFragment : BaseFragment<FragmentAddProductBinding>() {

    override fun getContentView() = R.layout.fragment_add_product

    override fun onCreated(savedInstanceState: Bundle?) {
        iv_add_product_ic_back.setOnClickListener { findNavController().navigateUp() }
    }

}