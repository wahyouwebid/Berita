package com.ujangwahyu.app.features.news.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ujangwahyu.app.common.utils.dateFormat
import com.ujangwahyu.app.common.utils.dateTimeHourAgo
import com.ujangwahyu.app.common.utils.loadImage
import com.ujangwahyu.app.databinding.AdapterNewsBinding
import com.ujangwahyu.app.features.news.domain.model.NewsItem

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

class NewsAdapter(
    private val showDetail: (NewsItem?) -> Unit
) : PagingDataAdapter<NewsItem, NewsAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(val binding: AdapterNewsBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            val item = getItem(position)
            if (item?.author.isNullOrEmpty()) {
                tvSourceName.text = item?.modelSource?.name
            } else {
                tvSourceName.text = item?.author + " \u2022 " + item?.modelSource?.name
            }

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
        val binding = AdapterNewsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    object DiffCallback : DiffUtil.ItemCallback<NewsItem>() {
        override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
            return oldItem == newItem
        }
    }
}