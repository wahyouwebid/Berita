package com.ujangwahyu.app.features.favourite.presentation

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.ujangwahyu.app.R
import com.ujangwahyu.app.common.base.BaseFragment
import com.ujangwahyu.app.common.utils.hide
import com.ujangwahyu.app.common.utils.show
import com.ujangwahyu.app.core.database.entity.FavouriteEntity
import com.ujangwahyu.app.core.mapper.DataMapper.toDataDetail
import com.ujangwahyu.app.core.paging.FooterAdapter
import com.ujangwahyu.app.databinding.FragmentFavouriteBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by wahyouwebid on 04 September 2023
 * Email: wahyouwebid@gmail.com
 * Github: github.com/wahyouwebid
 * Linkedin: linkedin.com/in/wahyouwebid,
 */

@AndroidEntryPoint
class FavouriteFragment: BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding::inflate) {

    private val viewModel: FavouriteViewModel by viewModels()

    private val navigation: NavController? by lazy {
        activity?.findNavController(R.id.nav_host_main)
    }

    private val adapter: FavouriteAdapter by lazy {
        FavouriteAdapter { goToDetail (it) }
    }

    override fun setupView(savedInstanceState: Bundle?) = with(binding){
        rvFavourite.adapter = adapter.withLoadStateFooter(FooterAdapter { adapter.retry() })
        rvFavourite.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvFavourite.setHasFixedSize(true)
        adapter.addLoadStateListener { loadState(it) }
    }

    private fun loadState(loadState: CombinedLoadStates) {
        with(binding) {
            if (loadState.source.refresh is LoadState.NotLoading &&
                loadState.append.endOfPaginationReached &&
                adapter.itemCount < 1
            ) {
                tvEmptyData.show()
            } else {
                tvEmptyData.hide()
            }
        }
    }

    override fun setupViewModel() {
        viewModel.getFavourite()
        viewModel.favouriteList.observe(viewLifecycleOwner) { result ->
            adapter.submitData(lifecycle, result)
        }
    }

    private fun goToDetail(data: FavouriteEntity?) {
        navigation?.navigate(
            R.id.action_navigation_favourite_to_detailFragment,
            bundleOf("data" to data?.toDataDetail())
        )
    }

}