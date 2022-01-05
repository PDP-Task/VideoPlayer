package com.example.videoplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.videoplayer.databinding.ActivityMainBinding
import net.alhazmy13.mediapicker.Video.VideoPicker

class MainActivity : AppCompatActivity() {
    private lateinit var bin: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bin.root)

        initView()

    }

    private fun initView() {
        bin.btnPlayVideo.setOnClickListener {
            pickVideo()
        }
    }

    private fun pickVideo() {
        val videoPicker = VideoPicker.Builder(this)
            .mode(VideoPicker.Mode.GALLERY)
            .directory(VideoPicker.Directory.DEFAULT)
            .extension(VideoPicker.Extension.MP4)
            .enableDebuggingMode(true)
        videoPicker.build()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == VideoPicker.VIDEO_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            val videoPaths = data!!.getStringArrayListExtra(VideoPicker.EXTRA_VIDEO_PATH)
            Log.d("TAG","onActivityResult: $videoPaths")
        }
    }
}