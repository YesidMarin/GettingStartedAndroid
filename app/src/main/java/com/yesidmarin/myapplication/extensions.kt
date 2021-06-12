package com.yesidmarin.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun ViewGroup.inflate(@LayoutRes resource: Int): View {
    return LayoutInflater
        .from(context)
        .inflate(resource,this,false)
}

fun ImageView.loadUrl(url: String){
    Glide.with(this).load(url).placeholder(R.drawable.ic_launcher_foreground).dontAnimate().into(this)
}