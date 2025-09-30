package com.maximatech.provaandroid.client.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maximatech.provaandroid.databinding.ClientCardItemBinding
import com.maximatech.provaandroid.client.model.ClientInformationItem

internal class ClientInformationAdapter(
    private val items: MutableList<ClientInformationItem> = mutableListOf()
) : RecyclerView.Adapter<ClientInformationAdapter.ViewHolder>() {

    fun updateItems(items: List<ClientInformationItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ClientCardItemBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).run {
                ViewHolder(this)
            }
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    internal class ViewHolder(val binding: ClientCardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ClientInformationItem) {
            binding.run {
                tvClientTitle.text = item.title
                tvClientSubtitle.text = item.subtitle
            }
        }
    }
}