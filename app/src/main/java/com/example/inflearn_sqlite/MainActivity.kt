package com.example.inflearn_sqlite

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.inflearn_sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var db : SQLiteHelperSample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        db = SQLiteHelperSample(this)

        binding.btnInsert.setOnClickListener {
            val etText = binding.etText
            db.insert(etText.text.toString())
            etText.setText("")
        }

        binding.btnGetAll.setOnClickListener {
            val arr = db.getAllData()
            binding.tvResult.text = arr.toString()
        }

        binding.btnDeleteAll.setOnClickListener {
            db.deleteAll()
        }

    }
}