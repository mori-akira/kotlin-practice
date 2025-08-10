package org.example.`02_variableKotlinFunction`

class MyNumber (val value: Int) {
    operator fun plus(other: MyNumber): MyNumber {
        return MyNumber(this.value + other.value)
    }

    operator fun minus(other: MyNumber): MyNumber {
        return MyNumber(this.value - other.value)
    }

    operator fun times(other: MyNumber): MyNumber {
        return MyNumber(this.value * other.value)
    }

    operator fun div(other: MyNumber): MyNumber {
        return MyNumber(this.value / other.value)
    }

    operator fun rem(other: MyNumber): MyNumber {
        return MyNumber(this.value % other.value)
    }

    operator fun compareTo(other: MyNumber): Int {
        return this.value.compareTo(other.value)
    }

    override fun toString(): String {
        return value.toString()
    }
}
