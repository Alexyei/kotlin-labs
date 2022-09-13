package com.example.kotlin_labs

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class TimeActivity : AppCompatActivity() {
    private lateinit var tvTime:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        val sdf = SimpleDateFormat("HH:mm:ss")
        val time: String = sdf.format(Date(System.currentTimeMillis()))

        tvTime = findViewById(R.id.tvTime)
        tvTime.text = time;
    }
}