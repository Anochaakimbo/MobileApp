package com.example.myapplication.kotlin1

class Girl {
    var age: Int = 0
        get() = field
        set(value) {
            field = if (value < 18)
                18
            else if (value >= 18 && value <= 30)
                value
            else
                value-3
        }
    var actualAge: Int = 0 }