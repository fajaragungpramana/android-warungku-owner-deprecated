package com.implizstudio.android.app.warungkuowner.ui.fragment.product.main

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.databinding.FragmentMainProductBinding
import com.implizstudio.android.app.warungkuowner.ui.adapter.TabAdapter
import com.implizstudio.android.app.warungkuowner.ui.base.BaseFragment
import com.implizstudio.android.app.warungkuowner.ui.fragment.product.category.all.CategoryAllProductFragment
import com.implizstudio.android.app.warungkuowner.ui.fragment.product.category.drink.CategoryDrinkProductFragment
import com.implizstudio.android.app.warungkuowner.ui.fragment.product.category.food.CategoryFoodProductFragment
import com.implizstudio.android.app.warungkuowner.ui.fragment.product.category.medicine.CategoryMedicineProductFragment
import com.implizstudio.android.app.warungkuowner.ui.fragment.product.category.tool.CategoryToolProductFragment
import kotlinx.android.synthetic.main.fragment_main_product.*

class MainProductFragment : BaseFragment<FragmentMainProductBinding>() {

    override fun getContentView() = R.layout.fragment_main_product

    override fun onCreated(savedInstanceState: Bundle?) {

        vp_main_product.adapter = TabAdapter(childFragmentManager).apply {
            set(CategoryAllProductFragment(), getString(R.string.all))
            set(CategoryFoodProductFragment(), getString(R.string.food))
            set(CategoryDrinkProductFragment(), getString(R.string.drink))
            set(CategoryMedicineProductFragment(), getString(R.string.medicine))
            set(CategoryToolProductFragment(), getString(R.string.tool))
        }
        tl_main_product.setupWithViewPager(vp_main_product)

        iv_main_product_ic_back.setOnClickListener { findNavController().navigateUp() }
        ib_main_product_add_product.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.f_main).apply {
                navigate(R.id.action_nav_main_product_to_nav_add_product)
            }
        }

    }

}