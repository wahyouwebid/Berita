package com.ujangwahyu.app.features.favourite.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ujangwahyu.app.common.utils.dateFormat
import com.ujangwahyu.app.common.utils.dateTimeHourAgo
import com.ujangwahyu.app.common.utils.loadImage
import com.ujangwahyu.app.core.database.entity.FavouriteEntity
import com.ujangwahyu.app.databinding.AdapterFavouriteBinding

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class FavouriteAdapter(
    private val showDetail: (FavouriteEntity?) -> Unit
) : PagingDataAdapter<FavouriteEntity, FavouriteAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(val binding: AdapterFavouriteBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            val item = getItem(position)

            tvTitle.text = item?.title

            if(item?.publishedAt != null){
                val dateTime = item.publishedAt?.substring(0, 19)
                tvDateTime.text = dateTime.dateFormat()
                tvTime.text = dateTime.dateTimeHourAgo()
            }

            ivThumbnail.loadImage(item?.urlToImage)

            root.setOnClickListener {
                showDetail.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterFavouriteBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    object DiffCallback : DiffUtil.ItemCallback<FavouriteEntity>() {
        override fun areItemsTheSame(oldItem: FavouriteEntity, newItem: FavouriteEntity): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: FavouriteEntity, newItem: FavouriteEntity): Boolean {
            return oldItem == newItem
        }
    }
}