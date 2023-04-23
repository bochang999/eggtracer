package com.example.eggtracker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import java.util.Date

class MainActivity : AppCompatActivity() {
    private val eggs = mutableListOf<Egg>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton: Button = findViewById(R.id.add_button)
        val removeButton: Button = findViewById(R.id.remove_button)
        val eggCountEditText: EditText = findViewById(R.id.egg_count)
        val eggListView: ListView = findViewById(R.id.egg_list)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, eggs)


        eggListView.adapter = adapter

        addButton.setOnClickListener {
            val count = eggCountEditText.text.toString().toIntOrNull() ?: 0
            addEggs(count)
            adapter.notifyDataSetChanged()
        }

        removeButton.setOnClickListener {
            val count = eggCountEditText.text.toString().toIntOrNull() ?: 0
            removeEggs(count)
            adapter.notifyDataSetChanged()
        }
    }

    private fun addEggs(count: Int) {
        for (i in 1..count) {
            val expirationDate = Date() // ここに賞味期限を計算するコードを追加してください。
            val newEgg = Egg(expirationDate)
            eggs.add(newEgg)
        }
    }

    private fun removeEggs(count: Int) {
        for (i in 1..count) {
            if (eggs.isNotEmpty()) {
                eggs.removeAt(0)
            }
        }
    }
}
