package com.example.lesson_14_homework

class SmallSicilian : SmallPizza () {

    var weight : Int

    set(value) {
        if (value < 350) weight = 350
    }

    get() = (200..1000).random()

}
