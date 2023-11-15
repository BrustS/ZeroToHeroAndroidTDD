package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

val textId = "0"
var textString = "Hello World!";

class MainActivity : AppCompatActivity() {

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(textId, textString)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        textString =  savedInstanceState.getString(textId) ?: ""
        super.onRestoreInstanceState(savedInstanceState)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.titleTextView)
        val button = findViewById<Button>(R.id.changeButton)
        text.text = textString
        button.setOnClickListener {
            textString = resources.getString(R.string.changedtext)
            text.text = textString
        }
    }
}