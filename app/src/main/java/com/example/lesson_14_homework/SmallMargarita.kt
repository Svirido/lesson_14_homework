package com.example.lesson_14_homework

class SmallMargarita : SmallPizza() {

    var basil : Int

        set(value) {
            if (value < 5) basil = 5
        }

        get() = (0..20).random()
}