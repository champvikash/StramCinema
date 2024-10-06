package com.example.streamcinema.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("load")
fun loadingImage(view : ImageView , url: String ){
    Glide.with(view).load(url).into(view)
}