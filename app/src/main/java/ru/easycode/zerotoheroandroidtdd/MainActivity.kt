package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

var enabled_button = true

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textView: TextView
    private val count = Count.Base(2,4)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        button = findViewById(R.id.incrementButton)
        button.isEnabled = enabled_button

        button.setOnClickListener {
         val result = count.increment(textView.text.toString())
          if (result is UiState.Max) {
              enabled_button = false
              button.isEnabled = enabled_button
          }
            textView.text = result.toString()
        }
    }
     override fun onSaveInstanceState(outState: Bundle) {
         super.onSaveInstanceState(outState)
        outState.putBoolean("key",enabled_button)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        enabled_button = savedInstanceState.getBoolean("key")
    }
}