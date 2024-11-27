package com.example.myapplication.kotlin1

class Lamp{
    private var isOn:Boolean = false

    fun turnOn() {isOn = true}

    fun turnOff() {isOn = false}

    fun displayLightStatus(){
        if(isOn == true)
            println("Lamp is on")
        else
            println("Lamp is off")
    }
}