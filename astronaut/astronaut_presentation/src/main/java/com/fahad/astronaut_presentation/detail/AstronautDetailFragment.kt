package com.fahad.astronaut_presentation.detail

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.fahad.astronaut_presentation.R
import com.fahad.astronaut_presentation.databinding.FragmentAstronautDetailBinding
import com.fahad.core.extension.collectOnStarted
import com.fahad.core.extension.loadFromUrl
import com.fahad.core.ui.BaseFragment
import com.fahad.core.ui.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AstronautDetailFragment : BaseFragment<FragmentAstronautDetailBinding>(
    FragmentAstronautDetailBinding::inflate,
    R.id.shimmer
) {

    private val args: AstronautDetailFragmentArgs by navArgs()
    private val astronautDetailViewModel: AstronautDetailViewModel by viewModels()

    private val astronautId: Int
    get() = args.astronautId

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initStateListeners()
        astronautDetailViewModel.getAstronautDetails(astronautId)
    }

    private fun initStateListeners() {
        astronautDetailViewModel.state.collectOnStarted(viewLifecycleOwner) {
            when (it) {
                is UIState.Success -> {
                    hideShimmer()
                    binding.apply {
                        it.data?.let { astronaut ->
                            astronautNameTextView.text = astronaut.name
                            astronautNationalityTextView.text = astronaut.nationality
                            astronautDobTextView.text = astronaut.dateOfBirth.toString()
                            astronautBioTextView.text = astronaut.bio
                            profileImageView.apply {
                                transitionName = astronaut.profileImageThumbnail
                                loadFromUrl(astronaut.profileImageThumbnail)
                            }
                        }
                    }
                }
                is UIState.Error -> {
                    hideShimmer()
                    showToast(it.message)
                }
                is UIState.Loading -> {
                    showShimmer()
                }
                else -> Unit
            }
        }
    }
}