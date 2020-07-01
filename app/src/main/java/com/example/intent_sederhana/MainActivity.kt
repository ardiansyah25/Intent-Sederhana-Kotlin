package com.example.intent_sederhana

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMoveActivity : Button = findViewById(R.id.btn_move_activity)
        val btnMoveActivityWithData : Button = findViewById(R.id.btn_move_activity_with_data)
        val btnMoveActivityWithObject: Button = findViewById(R.id.btn_move_activity_with_object)
        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityWithData.setOnClickListener(this)
        btnMoveActivityWithObject.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.btn_move_activity -> {
                 val moveIntent = Intent(this@MainActivity, MoveActivity::class.java )
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_with_data -> {
                val moveIntentWithData = Intent(this@MainActivity, MoveWithData::class.java )
                moveIntentWithData.putExtra(MoveWithData.EXTRA_NAME,"Ardiansyah")
                moveIntentWithData.putExtra(MoveWithData.EXTRA_AGE,28)
                startActivity(moveIntentWithData)
            }

            R.id.btn_move_activity_with_object -> {
                val person = Person(
                    "Ardiansyah",
                    20,
                    "ardianysah@gmail.com",
                    "pekanbaru"
                )
                val moveIntentWithObject = Intent(this@MainActivity, MoveWithObjectArray ::class.java)
                moveIntentWithObject.putExtra(MoveWithObjectArray.EXTRA_PERSON,person)
                startActivity(moveIntentWithObject)
            }

        }
    }

}

