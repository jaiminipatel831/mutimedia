package com.example.multimedia

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mediaPlayer = MediaPlayer.create(context, R.raw.music)
        mediaPlayer.start()

        positionBar.progress = 0
        seekbar.max = mediaPlayer.duration


        val play_btn = findViewById<Button>(R.id.play_btn) as Button
        play_btn.setOnClickListener{
            if(!mediaPlayer.isPlaying){
                mediaPlayer.start()
                play_btn.setImageReasource(R.drawable.ic_baseline_pause_24)
            }
            else{
                mediaPlayer.pause()
                play_btn.setImageReasource(R.drawable.ic_baseline_skip_previous_24)
            }
        }

        seekbar.setOnSeekBarChangeListner(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, pos: Int, changed: Boolean) {
            if(changed){
                mediaPlayer.seekTo(pos)
            }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }


}

private fun Button.setImageReasource(icBaselineSkipPrevious24: Int) {

}
