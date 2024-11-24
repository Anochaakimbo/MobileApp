package com.example.myapplication.kotlin1

import kotlin.time.times

fun main(){
    val subjectScore = arrayOf(67,52,73,85,42,78)
    println("There are " + subjectScore.size+ " Subj in array.")
    calculateGPAX(subjectScore)
}


fun calculateGPAX(scoreArr : Array<Int>) {
    val credits: Int = 3
    val sumCredit: Int = scoreArr.size * credits
    var sumGradePoint: Double = 0.0
    var GPA: Double = 0.0

    for (i in 0..scoreArr.size - 1) {
        val (gradeEng, gradeNum) = gradeFormat(scoreArr[i])

        sumGradePoint += gradeNum.toString().toDouble().times(credits)

        println("Grade of subject Number ${i.plus(1)} : ${scoreArr[i]} = $gradeEng : $gradeNum")
    }
    GPA = sumGradePoint / sumCredit
    print("GPAX = (")

    for(i in 0 .. scoreArr.size-1){
        val (gradeEng,gradeNum) = gradeFormat(scoreArr[i])
        print("(${gradeNum}*${credits})")
        if (i != scoreArr.size-1){
            print("+")
        }
    }
    print(") / $sumCredit = $GPA")
}

fun gradeFormat(subjScore: Int): List<Any> {
    var engFormat: String = ""
    var numFormat: Double = 0.0
    when (subjScore) {
        in 80..100 -> { engFormat = "A"; numFormat = 4.0 }
        in 75..79 -> { engFormat = "B+"; numFormat = 3.5 }
        in 70..74 -> { engFormat = "B"; numFormat = 3.0 }
        in 65..69 -> { engFormat = "C+"; numFormat = 2.5 }
        in 60..64 -> { engFormat = "C"; numFormat = 2.0 }
        in 55..59 -> { engFormat = "D+"; numFormat = 1.5 }
        in 50..54 -> { engFormat = "D"; numFormat = 1.0 }
        else -> { engFormat = "F"; numFormat = 0.0 }
    }
    return listOf(engFormat, numFormat)
}
