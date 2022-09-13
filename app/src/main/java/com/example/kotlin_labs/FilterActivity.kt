
package com.example.kotlin_labs

import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class FilterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var timeBtn:Button;
    private lateinit var dateBtn:Button;
    private lateinit var returnBtn:Button;
    private lateinit var etName:EditText;
    private lateinit var tvResult:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        timeBtn = findViewById(R.id.timeBtn)
        dateBtn = findViewById(R.id.dateBtn)
        returnBtn = findViewById(R.id.returnBtn)
        etName = findViewById(R.id.etName)
        tvResult = findViewById(R.id.tvResult)

        timeBtn.setOnClickListener(this)
        dateBtn.setOnClickListener(this)
        returnBtn.setOnClickListener(this)
    }

    val getAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        val name = it?.data?.getStringExtra("name")
        tvResult.text = "Your name is: $name 😀"
    }

    override fun onClick(v: View) {
        var intent:Intent;
        when (v.id){
            R.id.timeBtn -> {
                intent = Intent("com.example.kotlin_labs.action.showtime");
                intent.putExtra("name", etName.text.toString());
                startActivity(intent);
            }
            R.id.dateBtn -> {
                intent = Intent("com.example.kotlin_labs.action.showdate");
                intent.putExtra("name", etName.text.toString());
                startActivity(intent);
            }
            R.id.returnBtn ->{
                intent = Intent("com.example.kotlin_labs.action.getResult");
//                Toast.makeText(applicationContext,"sdddfd",Toast.LENGTH_LONG)
//                startActivityForResult(intent, 1);
                getAction.launch(intent)
            }
        }
    }
}