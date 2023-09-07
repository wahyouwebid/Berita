package com.ujangwahyu.app.features.detail.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.ujangwahyu.app.R
import com.ujangwahyu.app.common.base.BaseFragment
import com.ujangwahyu.app.common.utils.parcelable
import com.ujangwahyu.app.core.database.entity.FavouriteEntity
import com.ujangwahyu.app.databinding.FragmentDetailBinding
import com.ujangwahyu.app.features.detail.model.DataDetail
import com.ujangwahyu.app.features.favourite.presentation.FavouriteViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@AndroidEntryPoint
class DetailFragment: BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val viewModel: FavouriteViewModel by viewModels()

    private val navigation: NavController? by lazy {
        activity?.findNavController(R.id.nav_host_main)
    }

    private val dataNews: DataDetail? by lazy {
        arguments?.parcelable("data")
    }

    private var statusFavorite: Boolean = false

    @SuppressLint("SetJavaScriptEnabled")
    override fun setupView(savedInstanceState: Bundle?){
        with(binding) {
            toolbar.setToolbar(dataNews?.title) {
                navigation?.navigateUp()
            }
            webView.settings.javaScriptEnabled = true
            webView.settings.domStorageEnabled = true
            webView.webViewClient = WebViewClient()
            dataNews?.url?.let { webView.loadUrl(it) }

            fabAdd.setOnClickListener {
                setFavorite()
            }
        }
    }

    override fun setupViewModel() = with(binding) {
        viewModel.getFavouriteByTitle(dataNews?.title ?: "-")
        viewModel.favourite.observe(viewLifecycleOwner) {
            statusFavorite = it!= null
            checkStatusFavorite(it)
        }
    }


    private fun setFavorite() {
        statusFavorite = !statusFavorite
        setStatusFavorite(statusFavorite)
        if (statusFavorite) {
            viewModel.insertFavourite(
                FavouriteEntity(
                    title = dataNews?.title ?: "-",
                    url = dataNews?.url,
                    author = dataNews?.author,
                    description = dataNews?.description,
                    urlToImage = dataNews?.urlToImage,
                    publishedAt = dataNews?.publishedAt,
                    content = dataNews?.content,
                )
            )
        } else {
            viewModel.deleteFavourite( dataNews?.title ?: "-")
        }
    }

    private fun checkStatusFavorite(data: FavouriteEntity?) {
        if(data != null) {
            setDrawableIsFavorite()
        } else {
            setDrawableNotFavorite()
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            setDrawableIsFavorite()
        } else {
            setDrawableNotFavorite()
        }
    }

    private fun setDrawableIsFavorite() {
        binding.fabAdd.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_favourite_selected
            )
        )
    }

    private fun setDrawableNotFavorite() {
        binding.fabAdd.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_favourite_unselected
            )
        )
    }
}