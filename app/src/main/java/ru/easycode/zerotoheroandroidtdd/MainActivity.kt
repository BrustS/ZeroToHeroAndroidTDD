package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    private var uiState: UiState = UiState.Base("0")
    private lateinit var button: Button
    private lateinit var textView: TextView
    private val count = Count.Base(2, 4)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        button = findViewById(R.id.incrementButton)

        button.setOnClickListener {
            uiState = count.increment(textView.text.toString())
            uiState.apply(textView, button)
        }
    }
        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            outState.putSerializable(KEY, uiState)
        }

        override fun onRestoreInstanceState(savedInstanceState: Bundle) {
            super.onRestoreInstanceState(savedInstanceState)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                uiState = savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
            }
            uiState.apply(textView,button)
        }

    companion object {
         const val KEY = "key"
    }

}