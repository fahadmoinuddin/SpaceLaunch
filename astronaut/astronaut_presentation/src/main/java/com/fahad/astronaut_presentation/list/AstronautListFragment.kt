package com.fahad.astronaut_presentation.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.fahad.astronaut_presentation.R
import com.fahad.astronaut_presentation.databinding.FragmentAstronautListBinding
import com.fahad.core.extension.collectOnStarted
import com.fahad.core.ui.BaseFragment
import com.fahad.core.ui.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AstronautListFragment : BaseFragment<FragmentAstronautListBinding>(
    FragmentAstronautListBinding::inflate,
    R.id.shimmer
) {

    private val astronautListViewModel: AstronautListViewModel by viewModels()
    private val astronautListAdapter = AstronautListAdapter(mutableListOf()) { astronaut ->
        val action = AstronautListFragmentDirections
            .actionAstronautListFragmentToAstronautDetailFragment(astronaut.id, astronaut.name)
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        initView()
        initStateListeners()
        if (astronautListViewModel.hasData.not()) {
            getAstronautList()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.astronaut_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sortByName -> {
                if (astronautListViewModel.hasData) {
                    astronautListViewModel.sortListBy(AstronautListViewModel.SortOptions.NAME)
                }
                true
            }
            R.id.refresh -> {
                getAstronautList()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getAstronautList() {
        astronautListViewModel.getAstronautList()
    }

    private fun initView() {
        binding.astronautListRecyclerView.apply {
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = astronautListAdapter
        }
    }

    private fun initStateListeners() {
        astronautListViewModel.state.collectOnStarted(viewLifecycleOwner) {
            when (it) {
                is UIState.Success -> {
                    hideShimmer()
                    astronautListAdapter.updateList(it.data.orEmpty())
                }
                is UIState.Error -> {
                    hideShimmer()
                    showToast(it.message)
                }
                is UIState.Loading -> { showShimmer() }
                else -> Unit
            }
        }
    }
}