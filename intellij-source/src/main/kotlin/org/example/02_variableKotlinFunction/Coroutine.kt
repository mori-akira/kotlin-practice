package org.example.`02_variableKotlinFunction`

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.async

class Coroutine {
    fun runGlobal() {
        GlobalScope.launch {
            delay(1000L)
            println("Kogure")
        }
        print("My name is ")
        Thread.sleep(2000L)
    }

    fun runBlockingSample() {
        runBlocking {
            launch {
                printName()
            }
            print("My name is ")
        }
    }

    suspend fun printName() {
        delay(1000L)
        println("Kogure")
    }

    fun runAsync() {
        runBlocking {
            println("starting calculation...")
            val num1 = async {
                delay(3000L)
                2 + 3
            }
            val num2 = async {
                delay(5000L)
                4 + 6
            }
            println("The sum is ${num1.await() + num2.await()}")
        }
    }
}
