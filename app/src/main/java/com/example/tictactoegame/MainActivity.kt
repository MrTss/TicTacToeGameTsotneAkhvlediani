package com.example.tictactoegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            callActivity()
        }

    }

    private fun callActivity() {
        val Fname = findViewById<EditText>(R.id.FName)
        val Sname = findViewById<EditText>(R.id.SName)
        val message1 = Fname.text.toString()
        val message2 = Sname.text.toString()

        val intent = Intent(this,MainActivity2::class.java).also {
            it.putExtra("EXTRA_MESSAGE1", message1)
            it.putExtra("EXTRA_MESSAGE2", message2)
            startActivity(it)


        }
    }
}