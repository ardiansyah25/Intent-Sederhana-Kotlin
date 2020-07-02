package com.example.intent_sederhana

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult:TextView

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMoveActivity : Button = findViewById(R.id.btn_move_activity)
        val btnMoveActivityWithData : Button = findViewById(R.id.btn_move_activity_with_data)
        val btnMoveActivityWithObject: Button = findViewById(R.id.btn_move_activity_with_object)
        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        val btnMoveResult: Button = findViewById(R.id.btn_move_result)

        btnDialPhone.setOnClickListener(this)
        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityWithData.setOnClickListener(this)
        btnMoveActivityWithObject.setOnClickListener(this)
        btnMoveResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
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

            R.id.btn_dial_number -> {
                val phoneNumber = "08223b3415342"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.btn_move_result -> {
                val moveResult = Intent(this@MainActivity,MoveForResultActivity::class.java)
               startActivityForResult(moveResult, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE ){
            if (resultCode == MoveForResultActivity.RESULT_CODE ){
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE,0)
                tvResult.text = "Hasil: $selectedValue"
            }
        }
    }



}

