package com.example.kotlin_labs

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class InfoActivity : AppCompatActivity() {
    private lateinit var tvInfo:TextView;
    private lateinit var tvName:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        tvInfo = findViewById(R.id.tvInfo)
        tvName = findViewById(R.id.tvName)

        val action = intent.action

        var format = ""
        var textInfo = ""

// в зависимости от action заполняем переменные

// в зависимости от action заполняем переменные
        if (action == "com.example.kotlin_labs.action.showtime") {
            format = "HH:mm:ss"
            textInfo = "Time: "
        } else if (action == "com.example.kotlin_labs.action.showdate") {
            format = "dd.MM.yyyy"
            textInfo = "Date: "
        }

// в зависимости от содержимого переменной format
// получаем дату или время в переменную datetime

// в зависимости от содержимого переменной format
// получаем дату или время в переменную datetime
        val sdf = SimpleDateFormat(format)
        val datetime: String = sdf.format(Date(System.currentTimeMillis()))

        tvInfo.text = textInfo + datetime;
        tvName.text = "Your name is: "+intent.getStringExtra("name")
    }
}