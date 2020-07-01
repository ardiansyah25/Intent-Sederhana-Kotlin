package com.example.intent_sederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectArray : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object_array)

        val textObject:TextView = findViewById(R.id.tv_object_diterima)

        val person  = intent.getParcelableExtra(EXTRA_PERSON) as Person
        val text = "Name: ${person.name.toString()},\nEmail: ${person.email},\nAge:${person.age},\nLocation: ${person.city}"
        textObject.text = text

    }
}
