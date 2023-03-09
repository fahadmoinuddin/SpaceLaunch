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

abstract class BaseFragment<T: ViewBinding>: Fragment {
    constructor(
        inflate: Inflate<T>,
        @IdRes shimmer: Int?
    ) : super() {
        _inflate = inflate
        shimmerId = shimmer
    }

    constructor(inflate: Inflate<T>) : super() {
        _inflate = inflate
        shimmerId = null
    }

    private val _inflate: Inflate<T>
    @IdRes private val shimmerId: Int?

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
        shimmerId?.let {
            _binding.root.findViewById<ShimmerFrameLayout>(it).apply {
                startShimmer()
                visibility = View.VISIBLE
            }
        }
    }

    fun hideShimmer() {
        shimmerId?.let {
            _binding.root.findViewById<ShimmerFrameLayout>(it).apply {
                stopShimmer()
                visibility = View.GONE
            }
        }
    }

    fun showToast(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}