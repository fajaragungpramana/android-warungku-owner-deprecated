package com.implizstudio.android.app.warungkuowner.ui.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.implizstudio.android.app.warungkuowner.R
import com.implizstudio.android.app.warungkuowner.data.model.Tip
import com.implizstudio.android.app.warungkuowner.databinding.AdapterTipBinding
import com.implizstudio.android.app.warungkuowner.ui.base.BaseAdapter

class TipAdapter(context: Context, private val listTip: List<Tip>) : BaseAdapter<AdapterTipBinding, TipAdapter.ViewHolder, Tip>(context, listTip) {

    override fun getContentView() = R.layout.adapter_tip

    override fun getViewHolder(view: View) = ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listTip[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(tip: Tip) { getViewDataBinding().tip = tip }

    }

}