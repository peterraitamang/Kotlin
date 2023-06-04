package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberOfFish = 50
        val numberOfPlant = 23
        val fish = 50
        if (fish in 1..100) {
            println(fish)
            Log.i("compare", (+fish).toString())
        }

        when (numberOfFish) {
            0 -> println("Empty Tank")
            in 1..39 -> println("Got Fish")
            else -> println("Thats lot of fish")
        }

        //nullability
        var fishFoodTreats = 6
        fishFoodTreats = fishFoodTreats?.dec() ?: 0

        //arrays, lists, loops

        val school = listOf("apple", "banana", "lemon", "promeganate", "tomato")
        println(school)

        val myList = mutableListOf("hello", "world", "program")
        println(myList)
        myList.remove("program")
        println(myList)

        val week = arrayOf("sunday", "Monday", "Tuesday", "Wednesday")
        println(java.util.Arrays.toString(week))
        //[sunday, Monday, Tuesday, Wednesday]

        //can add mix type
        val mix = arrayOf("fish", 2)
        println(java.util.Arrays.toString(mix))
        //[fish, 2]

        //can only add integer type in an array
        val numbers = intArrayOf(1, 2, 3)
        println(java.util.Arrays.toString(numbers))
        //[1, 2, 3]

        val numbers1 = intArrayOf(1, 2, 3)
        val numbers2 = intArrayOf(4, 5, 6)
        val show = numbers2 + numbers1
        println(show[5])
        println(java.util.Arrays.toString(show))
        println(show[2])
        //6

        //nested arrays and list
        val numBers = intArrayOf(1, 2, 3)
        val oceans = listOf("Atlantic", "Pacific")
        val oddList = listOf(numBers, oceans, "Salmon")
        println(oddList)
        // output = [[I@34123b3, [Atlantic, Pacific], Salmon]

        val array = Array(5) { it * 2 }
        println(java.util.Arrays.toString(array))
        //[0, 2, 4, 6, 8]

        //loops
        val subjects = arrayOf("science", "maths", "computer", "social")
        for (element: String in subjects) {
            println(element + " ")
        }
        // science
        // maths
        // computer
        // social

        //loop through the elements and the indexes at the same time
        for ((index, element) in school.withIndex()) {
            println("Item at $index is $element\n")
        }
        // Item at 0 is apple
        // Item at 1 is banana
        // Item at 2 is lemon
        // Item at 3 is promeganete
        // Item at 4 is tomato

        //different loops
        for (i in 1..5)
            println(i)
        //12345

        for (i in 5 downTo 1)
            println(i)
        //54321

        for (i in 3..6 step 2)
            println(i)
        //35

        for (i in 'd'..'g')
            println(i)
        //defg


        //repeat loops
//        var bubbles = 0
//        while (bubbles < 50) {
//            bubbles++
//        }
//        println("$bubbles bubbles in the water\n")
//        do{
//            bubbles --
//        } while (bubbles > 50)
//        println("$bubbles bubbles in the water\n")
//
//        repeat(2){
//            println("A fish is swimming")
//        }

        val temperature = 10
        val isHot = if (temperature > 50) true else false
        println(isHot)

        val temp = 10
        val message = "The water temperature is ${if (temp > 50) " too warm " else "OK"}."
        println(message)

        fun feedTheFish() {
            val day = randomDay()
            val food = "pellets"
            println("Today is $day and the fish eat $food")
        }
        feedTheFish()

        //when expression. This is an alternative to switch statement.
        fun fishFood(day: String): String {
            var food = ""
            when (day) {
                "Monday" -> food = "flakes"
                "Tuesday" -> food = "pellets"
                "Wednesday" -> food = "redworms"
            }
            return food
        }

        fun feedTheFishes() {
            val day = randomDay()
            val food = fishFood(day)
            println("Today is $day and the fish eat $food")
        }
        feedTheFishes()
        //Today is Tuesday and the fish eat pellets

        //when statement
        val num = 2
        when (num) {
            1 -> println("One")
            2 -> println("Two")
            3 -> println("Three")
            4 -> println("Four")
            5 -> println("Five")
            else
            -> println("Number is not between 1  and 5")
        }
        val nums = 99
        when (nums) {
            1 -> println("One")
            2 -> println("Two")
            3 -> println("Three")
            in 4..8 -> println("Number is between 4 and 8")
            !in 9..12 -> println("Number is not between 9 and 12")
            else -> println("Number is not between 1 and 12")
        }
        //Number is not between 9 and 12

        //when without arguments
        val numbe = 5
        when {
            numbe < 1 -> println("Number is less than 1")
            numbe > 1 -> println("Number is greater than 1")
        }
//        val x = "Hello"
//        when(x){
//            is Int -> println("X is integer")
//            is String -> println("X is String")
//        }

        // default value for parameter
        fun swim(speed: String = "fast") {
            println("Swimming $speed")
        }

        swim()                                //default
        swim("slow")                    //positional argument
        swim(speed = "turtle-like")           //named parameter

        fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
            return when {
                temperature > 30 -> true
                dirty > 30 -> true
                day == "Sunday" -> true
                else -> false
            }
        }
        shouldChangeWater("Sunday")


    }

    fun randomDay(): String {
        val week = arrayOf("sunday", "Monday", "Tuesday", "Wednesday")
        return week[Random().nextInt(week.size)]
    }

}
