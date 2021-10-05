package com.example.tmobileassessment.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmobileassessment.R
import com.example.tmobileassessment.databinding.ItemLayoutBinding
import com.example.tmobileassessment.model.Image
import com.example.tmobileassessment.model.ResponseData
import com.example.tmobileassessment.model.Title
import com.squareup.picasso.Picasso

class TMobileAdapter(
    private var dataSet: ResponseData?
) : RecyclerView.Adapter<TMobileAdapter.TMobileViewHolder>() {

    class TMobileViewHolder(private val itemBinding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun onBind(
            image: Image, title: Title
        ) {
            Picasso.get().load(image.url).placeholder(R.drawable.placeholder)
                .into(itemBinding.ivImage)
            itemBinding.tvTitle.text = title.value
        }
    }

    fun updateDataSet(dataSet: ResponseData?) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TMobileViewHolder {
        return TMobileViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TMobileViewHolder, position: Int) {
        val card = dataSet?.page?.cards?.get(position)?.card
        val title = card?.title

        card?.image?.let {
            if (title != null) {
                holder.onBind(it, title)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataSet?.page?.cards?.size ?: 0
    }
}