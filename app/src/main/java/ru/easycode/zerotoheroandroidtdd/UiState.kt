package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(textView: TextView, decrementButton: Button, incrementButton: Button)
    data class Min(private val text: String) : UiState {
        override fun apply(textView: TextView, decrementButton: Button, incrementButton: Button) {
            decrementButton.isEnabled = false
            textView.text = text
            incrementButton.isEnabled = true
        }

    }

    data class Base(private val text: String) : UiState {
        override fun apply(textView: TextView, decrementButton: Button, incrementButton: Button) {
            textView.text = text
            decrementButton.isEnabled = true
            incrementButton.isEnabled = true
        }
    }

    data class Max(private val text: String) : UiState {
        override fun apply(textView: TextView, decrementButton: Button, incrementButton: Button) {
            incrementButton.isEnabled = false
            textView.text = text
            decrementButton.isEnabled = true
        }

    }
}