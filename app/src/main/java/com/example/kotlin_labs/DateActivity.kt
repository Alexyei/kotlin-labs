package com.example.kotlin_labs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class DateActivity : AppCompatActivity() {
    private lateinit var tvDate:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        tvDate =  findViewById(R.id.tvDate)

        val sdf = SimpleDateFormat("dd.MM.yyyy")
        val time: String = sdf.format(Date(System.currentTimeMillis()))

        tvDate.text = time;
    }
}