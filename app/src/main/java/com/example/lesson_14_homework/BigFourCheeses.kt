package com.example.lesson_14_homework

class BigFourCheeses : BigPizza() {

    var numberOfCheeses : Int

    set(value) {
        if (value < 3) numberOfCheeses = 3
    }

    get() = (0..10).random()
}
