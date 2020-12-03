package com.implizstudio.android.app.warungkuowner.ui.fragment.product.add

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.databinding.FragmentAddProductBinding
import com.implizstudio.android.app.warungkuowner.ui.base.BaseFragment
import com.implizstudio.android.app.warungkuowner.ui.component.FieldUnitComponent
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

        fmo_minimal_order.setUnit(fuc_available.getUnitText())
        fuc_available.setOnSelectedUnitListener(object : FieldUnitComponent.OnSelectedUnitListener {
            override fun getText(text: String) {
                fmo_minimal_order.setUnit(text)
            }
        })

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