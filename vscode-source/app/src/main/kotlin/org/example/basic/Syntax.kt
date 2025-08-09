package org.example.basic

class Syntax {
    fun variable() {
        val id = 100
        var name = "Kotlin"
        println("Variable id: $id, name: $name")
        name = "Kotlin Programming"
        println("Variable id: $id, name: $name")
    }

    fun variableWithType(): Unit {
        val id: Int = 200
        var name: String = "Kotlin with Type"
        println("Variable with type id: $id, name: $name")
    }

    fun functionDefinition(param: String): String {
        return param.repeat(3)
    }

    fun variableSentence() {
        val num1: Int = 100
        if (num1 < 100) {
            println("Number is less than 100")
        } else {
            println("Number is 100 or more")
        }

        when (num1) {
            0, 1 -> println("Number is zero or one")
            100 -> println("Number is hundred")
            else -> println("Number is greater than two")
        }

        when (num1) {
            in 0..50 -> println("Number is between 0 and 50")
            in 51..100 -> println("Number is between 51 and 100")
            else -> println("Number is greater than 100")
        }

        when {
            num1 < 100 -> println("Number is less than 100")
            else -> println("Number is 100 or more")
        }

        var num2 = 0
        while (num2 < 5) {
            println("Current number: $num2")
            num2++
        }

        for (i in 1..5) {
            println("Loop iteration: $i")
        }

        for (i in 1 until 10 step 2) {
            println("Loop with step: $i")
        }

        for (i in 10 downTo 1) {
            println("Counting down: $i")
        }

        val list = listOf("Kotlin", "Java", "Python")
        for (item in list) {
            println("Item in list: $item")
        }
    }
}

class ClassSyntax(val param1: String, val param2: Int) {
    fun showParam() {
        println("Parameter 1: $param1, Parameter 2: $param2")
    }
}

open class Animal(val name: String, val age: Int) {
    fun showInfo() = println("Animal Name: $name, Age: $age")
    open fun cries() = println("")
}

class Dog(name: String, age: Int) : Animal(name, age) {
    override fun cries() = println("Woof! Woof!")
}

sealed class Platform {
    abstract fun showName(): Unit
}

class Android : Platform() {
    override fun showName() = println("This is Android platform")
}

interface Computable {
    fun compute(): Int
}

class Computation : Computable {
    override fun compute(): Int {
        return 42
    }
}
