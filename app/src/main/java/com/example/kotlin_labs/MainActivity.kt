package com.example.kotlin_labs

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemClickListener {
    private lateinit var mainTextview:TextView;
    private lateinit var menuTextview:TextView;
    private lateinit var menuCheckbox:CheckBox;
    private lateinit var button:Button;
    private lateinit var secondActivityBtn:Button;
    private lateinit var mainEditText: EditText;
    private lateinit var mainListView: ListView
    private lateinit var listViewArray: ArrayList<String>
    private lateinit var listViewAdapter: ArrayAdapter<String>
    private lateinit var btnOk:Button;
    private lateinit var btnCancel:Button;
    private lateinit var btnFilter:Button;

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menu.add("menu1")
//        menu.add("menu2")
//        menu.add("menu3")
//        menu.add("menu4")

//        menu.add(0, 1, 0, "add");
//        menu.add(0, 2, 0, "edit");
//        menu.add(0, 3, 3, "delete");
//        menu.add(1, 4, 1, "copy");
//        menu.add(1, 5, 2, "paste");
//        menu.add(1, 6, 4, "exit");

        menuInflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
//        menu.setGroupVisible(1, menuCheckbox.isChecked);
        menu.setGroupVisible(R.id.group1, menuCheckbox.isChecked);

        return super.onPrepareOptionsMenu(menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show();

        val sb = StringBuilder()
// Выведем в TextView информацию о нажатом пункте меню
        sb.append("Item Menu");
        sb.append("\r\n groupId: " + item.groupId);
        sb.append("\r\n itemId: " + item.itemId);
        sb.append("\r\n order: " + item.order);
        sb.append("\r\n title: " + item.title);
        menuTextview.text = sb.toString();



        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainTextview = findViewById(R.id.mainTextview)
        button = findViewById(R.id.button)
        mainEditText = findViewById(R.id.mainEditText)
        mainListView = findViewById(R.id.mainListview)
        btnOk = findViewById(R.id.btnOk)
        btnCancel = findViewById(R.id.btnCancel)
        menuTextview = findViewById(R.id.textView)
        menuCheckbox = findViewById(R.id.chbExtMenu)
        secondActivityBtn = findViewById(R.id.SecondActivityBtn)
        btnFilter = findViewById(R.id.btnFilter)

        listViewArray = ArrayList()
        listViewAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, listViewArray)
        mainListView.adapter = listViewAdapter;
        mainListView.setOnItemClickListener(this)

        mainTextview.text = "Set in Kotlin";
        button.setOnClickListener(this)


        fun getIntent(cls: Class<*>): Intent {
            return Intent(this, cls)
        }


        var btnOnClk:View.OnClickListener = object: View.OnClickListener{
            override fun onClick(v: View?) {
                if (v != null) {
                    when (v.id) {
                        R.id.btnOk ->{                // кнопка ОК
                            mainTextview.text = "Нажата кнопка ОК"
                            Toast.makeText(applicationContext,"Нажата кнопка 🆗",Toast.LENGTH_SHORT).show()}
                        R.id.btnCancel -> {               // кнопка Cancel
                            mainTextview.text = "Нажата кнопка Cancel"
                            Toast.makeText(applicationContext,"Нажата кнопка ❌",Toast.LENGTH_LONG).show()
                        }
                        R.id.SecondActivityBtn -> {
                            startActivity(getIntent(ActivityTwo::class.java))
                        }
                        R.id.btnFilter ->{
                            startActivity(getIntent(FilterActivity::class.java))
                        }
                    }
                }

            }

        }

        btnOk.setOnClickListener(btnOnClk)
        btnCancel.setOnClickListener(btnOnClk)
        secondActivityBtn.setOnClickListener(btnOnClk)
        btnFilter.setOnClickListener(btnOnClk)
    }

    override fun onClick(p0: View?) {
        button.text = "Button pressed!"
        mainTextview.text = "${mainEditText.text} is learning Android development!"
        listViewArray.add(mainEditText.text.toString())
        listViewAdapter.notifyDataSetChanged()
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Log.d("omg android", p2.toString() + ": " + listViewArray[p2]);
        mainTextview.text = listViewArray[p2] + " is learning Android development!";

    }
}


