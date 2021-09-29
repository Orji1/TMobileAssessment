package com.example.tmobileassessment.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmobileassessment.R
import com.example.tmobileassessment.model.Image
import com.example.tmobileassessment.model.ResponseData
import com.example.tmobileassessment.model.Title
import com.squareup.picasso.Picasso

class TMobileAdapter(
    private var dataSet: ResponseData?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class TMobileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var textView: TextView = itemView.findViewById(R.id.tv_title)
        private var imageView: ImageView = itemView.findViewById(R.id.iv_image)

        fun onBind(
            image: Image, title: Title
        ) {
            Picasso.get().load(image.url).into(this.imageView)
            textView.text = title.value
        }
    }

    class TMobileViewHolderWithoutImage(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private var textView: TextView = itemView.findViewById(R.id.tv_title)
        fun onBind(
            title: Title
        ) {
            textView.text = title.value
        }
    }

    fun updateDataSet(dataSet: ResponseData?) {
        this.dataSet = dataSet
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1) {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout_no_image,
                parent,
                false
            )
            TMobileViewHolderWithoutImage(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
            return TMobileViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val card = dataSet?.page?.cards?.get(position)?.card
        val title = card?.title
        if (getItemViewType(position) == 2) {
            card?.image.let {
                if (it != null) {
                    if (title != null) {
                        (holder as TMobileViewHolder).onBind(it, title)
                    }
                }
            }
        } else
            title?.let { (holder as TMobileViewHolderWithoutImage).onBind(it) }
    }

    override fun getItemCount(): Int {
        return dataSet?.page?.cards?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        val image = dataSet?.page?.cards?.get(position)?.card?.image
        return if (image?.url.isNullOrEmpty()) 1 else 2
    }
}