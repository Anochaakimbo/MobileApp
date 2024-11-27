package com.example.myapplication.kotlininheritance

import kotlinx.coroutines.processNextEventInCurrentThread

open class Person(fName: String, lName: String,deptName:String) {
    val firstName : String
    val lastName : String
    protected val department : String

    init {
        firstName  = fName.replaceFirstChar { it.uppercase() }
        lastName = lName.replaceFirstChar { it.uppercase() }
        department = "$deptName , College of Computing"
    }

    open fun showDetail(){
        println("$firstName is at $department.")
    }

    companion object{
        fun showCompanion(first_name:String,last_name:String,age:Int){
            println("Person is called from companion object : $first_name $last_name is $age years old.")
        }
    }
}

class Teacher(fName: String, lName: String,deptName:String,year:Int): Person(fName, lName,deptName) {
    private var salary : Int = 0
    private val yearClass : Int = year
    private var creditClass : Int = 0

    override fun showDetail() {
        println("$firstName is a teacher for $yearClass years at $department.")
    }
    fun calSalary(){
        when{
            yearClass < 5 -> salary = 25000 + (2000 * yearClass)
            yearClass < 10 -> salary = 36000 + (2000 * (yearClass - 5))
            yearClass < 15 -> salary = 47000 + (2000 * (yearClass - 10))
            yearClass < 20 -> salary = 58000 + (2000 * (yearClass - 15))
            else -> salary = 60000 + (2000 * (yearClass-20))
        }
        println("$firstName's salary is  $salary bath.")
    }
    fun teach (subj:Subject) {
        println(subj.toString())
        creditClass += subj.credit

    }
    fun displayCredit(){
        println("$firstName teachers $creditClass credits.")
    }
}
    object Singleton_Person{
        val first_name = "David"
        val last_name = "Bowie"
        var age = 23
        fun showCompanion(){
            println("Person is called from singelton object : $first_name $last_name is $age years old.")
        }
    }
