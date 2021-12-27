package com.example.magicmamanapplication.activities

import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import com.example.magicmamanapplication.R
import kotlinx.android.synthetic.main.activity_sons.*
import java.util.ArrayList

class Sons : AppCompatActivity(){
    //change the seekbar position while the song is playing
    //to do this we need to create a runnable object and handler
    lateinit var runnable: Runnable
    lateinit var mediaPlayer: MediaPlayer
    private lateinit var mAudioManager: AudioManager
    var imageView: ImageView? = null
    var songTitle: TextView? = null
    var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sons)
        mAudioManager  = getSystemService(AUDIO_SERVICE) as AudioManager
        songTitle = findViewById(R.id.songTitle)
        imageView = findViewById(R.id.imageView)

        // creating an ArrayList to store our songs
        val songs = ArrayList<Int>()
        songs.add(0, R.raw.music1)
        songs.add(1, R.raw.music2)
        songs.add(2, R.raw.music3)
        songs.add(3, R.raw.music4)
        songs.add(4, R.raw.music5)
        songs.add(4, R.raw.music6)
        // intializing mediaplayer
        var mediaPlayer = MediaPlayer.create(
            applicationContext,
            songs[currentIndex]
        )


        //create our play button event
        play_btn.setOnClickListener {
//            seekbar.progress =0
            seekbar.max = mediaPlayer.duration
            if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                mediaPlayer!!.pause()
                play_btn.setImageResource(R.drawable.play)
            } else {
                mediaPlayer.start()
                play_btn.setImageResource(R.drawable.pause)
            }
            songNames()
        }
        //create our next button event
        next_btn.setOnClickListener {
            if(mediaPlayer !=null){
                play_btn.setImageResource(R.drawable.pause)
            }
            if (currentIndex < songs.size - 1) {
                currentIndex++
            } else {
                currentIndex = 0
            }
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }
            mediaPlayer = MediaPlayer.create(
                applicationContext,
                songs[currentIndex]
            )
            mediaPlayer.start()
            songNames()
        }
        //create our previous button event

        prev_btn.setOnClickListener {
            if (mediaPlayer != null) {
                play_btn.setImageResource(R.drawable.pause)
            }
            if (currentIndex > 0) {
                currentIndex--
            } else {
                currentIndex = songs.size - 1
            }
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }
            mediaPlayer = MediaPlayer.create(
                applicationContext,
                songs[currentIndex]
            )
            mediaPlayer.start()
            songNames()
        }
        // seekbar duration
        mediaPlayer!!.setOnPreparedListener {
            seekbar!!.max = mediaPlayer!!.duration
//            mediaPlayer!!.start()
        }
        seekbar!!.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                if (changed) {
                    mediaPlayer!!.seekTo(pos)
                    seekbar!!.progress = pos
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })
        runnable = Runnable {
            seekbar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable,1000)
        }
        //when the music finish to play the seekbar will back to 0 and the button image change
        mediaPlayer.setOnCompletionListener {
            play_btn.setImageResource(R.drawable.play)
            seekbar.progress = 0
        }

        Thread {
            while (mediaPlayer != null) {
                try {
                    if (mediaPlayer!!.isPlaying) {
                        val message = Message()
                        message.what = mediaPlayer!!.currentPosition
                        handler.sendMessage(message)
                        Thread.sleep(1000)
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()

    }

    private fun songNames() {
        if (currentIndex == 0) {
            songTitle!!.text = "Musique 1"
            imageView!!.setImageResource(R.drawable.musique1)
        }
        if (currentIndex == 1) {
            songTitle!!.text = "Musique 2"
            imageView!!.setImageResource(R.drawable.musique2)
        }
        if (currentIndex == 2) {
            songTitle!!.text = "Musique 3"
            imageView!!.setImageResource(R.drawable.musique3)
        }
        if (currentIndex == 3) {
            songTitle!!.text = "Musique 4"
            imageView!!.setImageResource(R.drawable.musique4)
        }
        if (currentIndex == 4) {
            songTitle!!.text = "Musique 5"
            imageView!!.setImageResource(R.drawable.musique5)
        }
        if (currentIndex == 5) {
            songTitle!!.text = "Musique 6"
            imageView!!.setImageResource(R.drawable.musique6)
        }

    }
    @SuppressLint("Handler Leak")
    var handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            seekbar!!.progress = msg.what
        }
    }

    companion object {
        var mediaPlayer: MediaPlayer? = null
    }

}