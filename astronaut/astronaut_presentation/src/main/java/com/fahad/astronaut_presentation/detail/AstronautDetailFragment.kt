package com.fahad.astronaut_presentation.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.fahad.astronaut_presentation.R
import com.fahad.astronaut_presentation.databinding.FragmentAstronautDetailBinding
import com.fahad.core.enum.DateFormatEnum
import com.fahad.core.extension.collectOnStarted
import com.fahad.core.extension.loadFromUrl
import com.fahad.core.extension.toCustomString
import com.fahad.core.ui.BaseFragment
import com.fahad.core.ui.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AstronautDetailFragment : BaseFragment<FragmentAstronautDetailBinding>(
    FragmentAstronautDetailBinding::inflate,
    R.id.shimmer,
    R.id.retryView
) {

    private val args: AstronautDetailFragmentArgs by navArgs()
    private val astronautDetailViewModel: AstronautDetailViewModel by viewModels()

    private val astronautId: Int
    get() = args.astronautId

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initStateListeners()
        initClickListeners()
        getAstronautDetails()
    }

    private fun initStateListeners() {
        astronautDetailViewModel.state.collectOnStarted(viewLifecycleOwner) {
            when (it) {
                is UIState.Success -> {
                    hideShimmer()
                    hideRetry()
                    binding.apply {
                        it.data?.let { astronaut ->
                            astronautNameTextView.text = astronaut.name
                            astronautNationalityTextView.text = astronaut.nationality
                            astronautDobTextView.text =
                                getString(
                                    com.fahad.core.R.string.born_on,
                                    astronaut.dateOfBirth.toCustomString(DateFormatEnum.Day_Month_Year)
                                )
                            astronautBioTextView.text = astronaut.bio
                            profileImageView.apply {
                                loadFromUrl(astronaut.profileImageThumbnail)
                            }
                        }
                    }
                }
                is UIState.Error -> {
                    hideShimmer()
                    showRetry()
                }
                is UIState.Loading -> {
                    hideRetry()
                    showShimmer()
                }
                else -> Unit
            }
        }
    }

    private fun getAstronautDetails() {
        astronautDetailViewModel.getAstronautDetails(astronautId)
    }

    private fun initClickListeners() {
        binding.retryView.root.setOnClickListener {
            getAstronautDetails()
        }
    }
}