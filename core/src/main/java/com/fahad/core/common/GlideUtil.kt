package com.fahad.core.common

import androidx.annotation.DrawableRes
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import com.fahad.core.R

object GlideUtil {
    fun defaultLoadingOption(@DrawableRes fallbackImage: Int = R.drawable.ic_baseline_broken_image_24): RequestOptions {
        val shimmerDrawable = ShimmerDrawable().apply {
            setShimmer(shimmer)
        }

        return RequestOptions()
            .error(fallbackImage)
            .fallback(fallbackImage)
            .placeholder(shimmerDrawable)
            .priority(Priority.HIGH)
    }

    fun centerCropOption(): RequestOptions {
        return defaultLoadingOption().centerCrop()
    }

    private val shimmer = Shimmer.AlphaHighlightBuilder()
        .setDuration(1500)
        .setBaseAlpha(0.7f)
        .setHighlightAlpha(0.6f)
        .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
        .setAutoStart(true)
        .build()
}