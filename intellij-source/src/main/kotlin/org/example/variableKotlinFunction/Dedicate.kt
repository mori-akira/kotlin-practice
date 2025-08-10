package org.example.variableKotlinFunction

interface CalculationExecutor {
    val message: String
    fun calc(num1: Int, num2: Int): Int
    fun printStartMessage()
}

class CommonCalculationExecutor(override val message: String = "calc") : CalculationExecutor {
    override fun calc(num1: Int, num2: Int): Int {
        throw IllegalStateException("Not implemented")
    }

    override fun printStartMessage() {
        println("start $message")
    }
}

class Dedicate(private val calculationExecutor: CalculationExecutor) :
    CalculationExecutor by calculationExecutor {
    override fun calc(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}

class Person1 {
    var name: String = ""
        get() {
            println("Getting name: $field")
            return field
        }
        set(value) {
            println("Setting name to: $value")
            field = value
        }

    var address: String = ""
        get() {
            println("Getting address: $field")
            return field
        }
        set(value) {
            println("Setting address to: $value")
            field = value
        }
}

class DelegateWithMessage<T> {
    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): T {
        println("Getting value for ${property.name}: $value")
        return value!!
    }

    operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: T) {
        println("Setting value for ${property.name}: $value")
        this.value = value
    }
}

class Person2 {
    var name: String by DelegateWithMessage()
    var address: String by DelegateWithMessage()
}
