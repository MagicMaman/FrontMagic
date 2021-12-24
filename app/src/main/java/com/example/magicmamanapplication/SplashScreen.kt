package com.example.magicmamanapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.TextView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val topTextView:TextView =findViewById(R.id.TopTextView)
        val bottomTextView:TextView =findViewById(R.id.BottomTextView)
        val topAnimation= AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomAnimation= AnimationUtils.loadAnimation(this, R.anim.bottom_animation)


        topTextView.startAnimation(topAnimation)
        bottomTextView.startAnimation(bottomAnimation)
        val splashScreenTimeOut =4000
        val homeIntent = Intent(this, MainActivity::class.java)

        Handler().postDelayed({
            startActivity(homeIntent)
            finish()
        }, splashScreenTimeOut.toLong() )
    }
}