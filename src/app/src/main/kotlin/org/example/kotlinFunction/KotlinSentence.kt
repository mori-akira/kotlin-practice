package org.example.kotlinFunction

class KotlinSentence {
    fun printOddOrEven(num: Int) {
        val text = if (num % 2 == 0) "even" else "odd"
        println("The number $num is $text.")
    }

    fun printRemainderDividedByThree(num: Int) {
        val remainder =
                when {
                    num % 3 == 0 -> 0
                    num % 3 == 1 -> 1
                    else -> 2
                }
        println("The remainder of $num divided by 3 is $remainder.")
    }
}
