package com.example.myapplication.kotlininheritance

fun main(){
    val person1 = Person("Alice","Wonderland","Computer Science")
    println("MEMBER NO 1 : " + person1.firstName + " " + person1.lastName)
    person1.showDetail()
    println()

    println("MEMBER NO 2 : ")
    Person.showCompanion("Bobby","Brown",25)

    var subject1 = Subject("SC362007","Mobile Device Programming",3)
    var subject2 = Subject("SC362005","Database Analysis and Design",3)
    var subject3 = Subject("SC361003","Object Oriented Concepts and Programming",1)

    var person2 = Teacher("Chris","Evans","Information Technology",25)
    println("MEMBER NO 3 : " + person2.firstName + " " + person2.lastName)
    person2.showDetail()
    person2.calSalary()
    println(person2.firstName + "teaches: ")
    person2.teach(subject1)
    person2.teach(subject2)
    person2.teach(subject3)
    person2.displayCredit()
    println()

    println("MEMBER NO 4 : ")
    Singleton_Person.showCompanion()
}