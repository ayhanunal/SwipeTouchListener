package com.ayhanunal.swipetouchlistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ayhanunal.swipetouchlistener.listeners.OnSwipeTouchListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setOnTouchListener(object : OnSwipeTouchListener(applicationContext){

            override fun onDoubleTap() {
                Toast.makeText(applicationContext, "Double Tap", Toast.LENGTH_SHORT).show()
                super.onDoubleTap()
            }

            override fun onSwipeBottom() {
                Toast.makeText(applicationContext, "Swipe Bottom", Toast.LENGTH_SHORT).show()
                super.onSwipeBottom()
            }

            override fun onSwipeLeft() {
                Toast.makeText(applicationContext, "Swipe Left", Toast.LENGTH_SHORT).show()
                super.onSwipeLeft()
            }

            override fun onSwipeRight() {
                Toast.makeText(applicationContext, "Swipe Right", Toast.LENGTH_SHORT).show()
                super.onSwipeRight()
            }

            override fun onSwipeTop() {
                Toast.makeText(applicationContext, "Swipe Top", Toast.LENGTH_SHORT).show()
                super.onSwipeTop()
            }

        })

    }
}