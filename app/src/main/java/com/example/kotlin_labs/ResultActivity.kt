package com.example.kotlin_labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class ResultActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnSend:Button;
    private lateinit var etResultName: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        btnSend = findViewById(R.id.btnSend)
        etResultName = findViewById(R.id.etResultName)

        btnSend.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val intent = Intent()
        intent.putExtra("name", etResultName.text.toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}