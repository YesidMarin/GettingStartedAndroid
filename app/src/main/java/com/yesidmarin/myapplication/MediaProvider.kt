package com.yesidmarin.myapplication

object MediaProvider {

    fun getItems(): List<MediaItem> = (1..20).map { count ->
        MediaItem(
            "Title $count",
            "https://placekitten.com/200/200?image=$count",
            if (count % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
        )
    }
}