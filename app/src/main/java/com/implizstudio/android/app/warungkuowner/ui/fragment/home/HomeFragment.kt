package com.implizstudio.android.app.warungkuowner.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.data.model.constant.Constant
import com.implizstudio.android.app.warungkuowner.databinding.FragmentHomeBinding
import com.implizstudio.android.app.warungkuowner.ui.adapter.TipAdapter
import com.implizstudio.android.app.warungkuowner.ui.base.BaseFragment
import com.implizstudio.android.app.warungkuowner.util.TemporarySave
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private companion object {
        const val CATEGORY = "OWNER"
    }

    private val viewModel by viewModels<HomeViewModel>()

    @Inject
    lateinit var temporarySave: TemporarySave

    override fun getContentView() = R.layout.fragment_home

    override fun onCreated(savedInstanceState: Bundle?) {
        getViewDataBinding().viewModel = viewModel

        srl_home.setOnRefreshListener {
            viewModel.isRefreshing.observe(viewLifecycleOwner, { srl_home.isRefreshing = it })
        }

        viewModel.reportToday(temporarySave.get(Constant.KEY_OWNER_ID, "") as String)
            .observe(viewLifecycleOwner, { getViewDataBinding().reportResult = it })

        viewModel.getTip(CATEGORY).observe(viewLifecycleOwner, { listTip ->
            rv_tip.let {
                it.layoutManager =
                    LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                it.adapter = TipAdapter(requireActivity(), listTip)
            }
        })

    }

}