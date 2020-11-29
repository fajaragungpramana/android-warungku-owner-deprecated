package com.implizstudio.android.app.warungkuowner.ui.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<V: ViewDataBinding, H: RecyclerView.ViewHolder, I>
    (private val context: Context, private val listItem: List<I>): RecyclerView.Adapter<H>() {

    private lateinit var viewDataBinding: V

    abstract fun getViewHolder(view: View): H

    abstract fun getContentView(): Int

    override fun getItemCount() = listItem.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): H {
        viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(context), getContentView(), parent, false)
        return getViewHolder(viewDataBinding.root)
    }

    protected fun getViewDataBinding() = viewDataBinding

}