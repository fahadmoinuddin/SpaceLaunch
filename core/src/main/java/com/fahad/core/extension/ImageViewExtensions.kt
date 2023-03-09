package com.fahad.core.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.fahad.core.common.GlideUtil

fun ImageView.loadFromUrl(url: String?) {
    Glide.with(context)
        .load(url)
        .apply(GlideUtil.centerCropOption())
        .into(this)
}
