package org.example.`02_variableKotlinFunction`

class User1(id: Int) {
    val id: Int = id
    var name: String = "User$id"
}

data class User2(val id: Int, var name: String = "User$id")
