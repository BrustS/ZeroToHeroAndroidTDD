package ru.easycode.zerotoheroandroidtdd

interface  Count {
      fun increment(number: String) : String
        class Base(private var step: Int) : Count {
            init {
                if (step <= 0) throw IllegalStateException("step should be positive, but was $step")
            }

        override fun increment(number: String): String {
            return (step + number.toInt()).toString()
        }

    }
}