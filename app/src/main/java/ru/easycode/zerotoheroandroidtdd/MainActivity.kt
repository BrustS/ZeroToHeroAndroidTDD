package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

val textId = ""
var vision = 0

class MainActivity : AppCompatActivity() {

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(textId, vision)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        vision = savedInstanceState.getInt(textId)
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.hideButton)
        val textview = findViewById<TextView>(R.id.titleTextView)
        textview.visibility = if (vision == 1) View.GONE else View.VISIBLE

        button.setOnClickListener {
            textview.visibility = View.GONE
            vision = 1
        }

    }
}