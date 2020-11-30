package com.implizstudio.android.app.warungkuowner.ui.fragment.product.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
        (activity as AppCompatActivity).let {
            it.setSupportActionBar(t_main_product)
            it.title = null
        }

        vp_main_product.adapter = TabAdapter(childFragmentManager).apply {
            set(CategoryAllProductFragment(), "All")
            set(CategoryFoodProductFragment(), "Food")
            set(CategoryDrinkProductFragment(), "Drink")
            set(CategoryMedicineProductFragment(), "Medicine")
            set(CategoryToolProductFragment(), "Tool")
        }
        tl_main_product.setupWithViewPager(vp_main_product)

    }

}