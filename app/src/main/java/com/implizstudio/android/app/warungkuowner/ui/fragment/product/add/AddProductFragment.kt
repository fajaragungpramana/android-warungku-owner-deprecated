package com.implizstudio.android.app.warungkuowner.ui.fragment.product.add

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.implizstudio.android.app.component.field.UnitField
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.databinding.FragmentAddProductBinding
import com.implizstudio.android.app.warungkuowner.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_add_product.*
import java.text.SimpleDateFormat
import java.util.*

class AddProductFragment : BaseFragment<FragmentAddProductBinding>() {

    private val calendar = Calendar.getInstance()
    private val date = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
        calendar.apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, monthOfYear)
            set(Calendar.DAY_OF_MONTH, dayOfMonth)
        }

        tie_expired.setText(
            SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)
        )
    }

    override fun getContentView() = R.layout.fragment_add_product

    override fun onCreated(savedInstanceState: Bundle?) {
        iv_add_product_ic_back.setOnClickListener { findNavController().navigateUp() }

        val listWeight = resources.getStringArray(R.array.list_unit_weight)
        val listAvailable = resources.getStringArray(R.array.list_unit_available)

        uf_weight.setUnitList(listWeight)
        uf_available.let {
            it.setUnitList(listAvailable)
            it.setOnSelectedUnitListener(object : UnitField.OnSelectedUnitListener {
                override fun getUnitText(text: String) {
                    uf_minimal_order.setOnSelectedUnitText(text)
                }
            })
        }
        uf_minimal_order.setOnSelectedUnitText(listAvailable[0])

        tie_expired.setOnClickListener {
            DatePickerDialog(
                requireActivity(),
                date,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

}
