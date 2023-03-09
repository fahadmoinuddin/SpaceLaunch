package com.fahad.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.facebook.shimmer.ShimmerFrameLayout
import com.fahad.core.extension.Inflate

/**
 * BaseFragment can take 3 parameters
 * _inflate - ViewBinding inflate to get the binding object
 * _shimmerId - layout view id from xml - this is to show loading animation in the screen
 * _retryViewId - layout view id from xml - this is to show a retry view in case of errors.
 */
abstract class BaseFragment<T : ViewBinding> : Fragment {

    constructor(
        inflate: Inflate<T>,
        @IdRes shimmerId: Int?,
        @IdRes retryViewId: Int?
    ) : super() {
        _inflate = inflate
        _shimmerId = shimmerId
        _retryViewId = retryViewId
    }

    constructor(inflate: Inflate<T>) : super() {
        _inflate = inflate
        _shimmerId = null
        _retryViewId = null
    }

    private val _inflate: Inflate<T>

    @IdRes private val _shimmerId: Int?

    @IdRes private val _retryViewId: Int?

    private lateinit var _binding: T
    val binding
        get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = _inflate(inflater, container, false)
        return _binding.root
    }

    fun showShimmer() {
        _shimmerId?.let {
            _binding.root.findViewById<ShimmerFrameLayout>(it).apply {
                startShimmer()
                visibility = View.VISIBLE
            }
        }
    }

    fun hideShimmer() {
        _shimmerId?.let {
            _binding.root.findViewById<ShimmerFrameLayout>(it).apply {
                stopShimmer()
                visibility = View.GONE
            }
        }
    }

    fun showToast(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showRetry() {
        _retryViewId?.let {
            _binding.root.findViewById<View>(it).apply {
                visibility = View.VISIBLE
            }
        }
    }

    fun hideRetry() {
        _retryViewId?.let {
            _binding.root.findViewById<View>(it).apply {
                visibility = View.GONE
            }
        }
    }
}
