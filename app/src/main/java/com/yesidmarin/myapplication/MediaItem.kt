package com.yesidmarin.myapplication

data class MediaItem(val title: String, var url: String, val type: Type) {
    enum class Type {PHOTO, VIDEO}
}
