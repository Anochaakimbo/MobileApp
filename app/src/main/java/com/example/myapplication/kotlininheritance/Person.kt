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


class Student(fName: String, lName: String,deptName:String): Person(fName, lName,deptName) {
    private var creditTotal : Int = 0
    private var gradeTotal : Double = 0.0

    override fun showDetail() {
        print("$firstName is a student at $department,College of Computing")
    }

    fun gradeEnroll(subj: Subject,score:Int){
        var gradeAlphabet : String = ""
        var gradeNum : Double = 0.0
        when{
            score < 50 -> {gradeAlphabet = "F" ; gradeNum = 0.0}
            score in 50 .. 54  -> {gradeAlphabet = "D" ; gradeNum = 1.0}
            score in 55..59 -> {gradeAlphabet = "D+" ; gradeNum = 1.5}
            score in 60 .. 64 -> {gradeAlphabet = "C" ; gradeNum = 2.0}
            score in 65..69 -> {gradeAlphabet = "C+" ; gradeNum = 2.5}
            score in 70..74 -> {gradeAlphabet = "B" ; gradeNum = 3.0}
            score in 74..79-> {gradeAlphabet = "B+" ; gradeNum = 3.5}

            else -> { gradeAlphabet = "A"; gradeNum = 4.0 }
        }

        creditTotal += subj.credit
        gradeTotal += (gradeNum * subj.credit)
        println("${subj.toString()} Score : $score , Grade : $gradeAlphabet")
    }
    fun displayGPA(){
        val gpa = gradeTotal / creditTotal
        println(String.format("%s's GPA is %.2f",firstName,gpa))
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
