package com.fahad.astronaut_presentation.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.fahad.astronaut_presentation.databinding.FragmentAstronautListBinding
import com.fahad.core.extension.collectOnStarted
import com.fahad.core.ui.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AstronautListFragment : Fragment() {

    private lateinit var binding: FragmentAstronautListBinding
    private val astronautListViewModel: AstronautListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAstronautListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        astronautListViewModel.state.collectOnStarted(viewLifecycleOwner) {
            when (it) {
                is UIState.Success -> {
                    Log.d("Astronaut", it.data?.firstOrNull()?.name.orEmpty())
                }
                is UIState.Error -> {}
                is UIState.Loading -> {}
                else -> Unit
            }
        }
    }
}