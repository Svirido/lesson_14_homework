package com.example.lesson_14_homework

class BigNeapolitan : BigPizza() {

    var tomatoVariety : String

        set(value) {
           if (value == "") tomatoVariety = "Красный"
        }

        get() = "Сорт томатов + $tomatoVariety"

}