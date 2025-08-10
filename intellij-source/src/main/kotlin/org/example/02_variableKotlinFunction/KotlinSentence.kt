package org.example.`02_variableKotlinFunction`

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

class Accessor(field2: String?) {
    val field: String = "dangerous"
    var field1: String = ""
    val field2: String = field2 ?: "field2 default value"
    lateinit var field3: String
    var field4: String = "field4"
        get() {
            return "value=$field"
        }
        set(value: String) {
            field = value.repeat(2)
        }

    // 勝手に生成されるため、自分で定義するとエラーになる
    // fun getField(): String {
    //     return field
    // }

    // fun setField(value: String) {
    //     field = value
    // }
}
