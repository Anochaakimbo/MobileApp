package com.example.myapplication.kotlin1

import androidx.compose.ui.text.capitalize

open class Person(age: Int, name: String) {
    init {
        println("My name is $name.")
        println("My age is $age")
    }
}
class Teacher(age: Int, name: String): Person(age, name) {
    fun teach () {
        println("I teach in primary school.")
    }
}