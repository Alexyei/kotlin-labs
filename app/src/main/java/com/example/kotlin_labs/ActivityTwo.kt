package com.example.kotlin_labs

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

const val TAG = "ACTIVITY_TWO"
class ActivityTwo : AppCompatActivity() {

    private lateinit var backBtn: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        backBtn = findViewById(R.id.backBtn)
        val intent = Intent(this, MainActivity::class.java)
        backBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                startActivity(intent)
            }

        })


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SecondActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SecondActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SecondActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "SecondActivity: onStop()")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SecondActivity: onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "SecondActivity: onRestart()")
    }


}






