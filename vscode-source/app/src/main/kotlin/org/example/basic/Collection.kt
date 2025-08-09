package org.example.basic

class Collection {
    fun list() {
        val primeNumbers: List<Int> = listOf<Int>(2, 3, 5, 7, 11)
        primeNumbers.forEach { println("Prime number: $it") }
        primeNumbers.forEach { number -> println("Prime number: $number") }
        println("First prime number: ${primeNumbers.first()}")
        println("Second prime number: ${primeNumbers[1]}")
        println("Last prime number: ${primeNumbers.last()}")
        primeNumbers
                .reduce { operation, number ->
                    println("Operation: $operation, Number: $number")
                    operation + number
                }
                .let { sum -> println("Sum of prime numbers: $sum") }

        val languages: List<String> = listOf("Kotlin", "Java", "Python")
        // strs.add("JavaScript") // Cannot add to a List
        println("String list: $languages")

        val mutableLanguages: MutableList<String> = mutableListOf("Kotlin", "Java", "Python")
        mutableLanguages.add("JavaScript")
        println("Mutable String list: $mutableLanguages")
    }

    fun map() {
        val numberMap: Map<Int, String> = mapOf(1 to "One", 2 to "Two", 3 to "Three")
        println("Number map: $numberMap")
        println("Value for key 2: ${numberMap[2]}")

        val mutableLanguageMap: MutableMap<String, String> =
                mutableMapOf("Kotlin" to "Great!", "Java" to "Old...")
        mutableLanguageMap["Python"] = "Popular"
        mutableLanguageMap["JavaScript"] = "Versatile"
        println("Mutable language map: $mutableLanguageMap")
        println("contains JavaScript: ${mutableLanguageMap.containsKey("JavaScript")}")
        println("contains C++: ${mutableLanguageMap.containsKey("C++")}")
    }

    fun set() {
        val set = setOf(1, 2, 3, 4, 5)
        println("Set: $set")

        val mutableSet = mutableSetOf(1, 2, 3, 4, 5)
        mutableSet.add(6)
        mutableSet.add(7)
        println("Mutable Set: $mutableSet")
    }
}
