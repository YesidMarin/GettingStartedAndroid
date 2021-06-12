package com.yesidmarin.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.yesidmarin.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter: MediaAdapter by lazy { MediaAdapter(MediaProvider.getItems()) {toast(it.title)} }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        adapter.items = MediaProvider.getItems().let { media ->
            when(item.itemId) {
                R.id.filter_photos -> media.filter { it.type == MediaItem.Type.PHOTO }
                R.id.filter_videos -> media.filter { it.type == MediaItem.Type.VIDEO }
                R.id.filter_all -> media
                else -> emptyList()
            }
        }

        return super.onOptionsItemSelected(item)
    }

}