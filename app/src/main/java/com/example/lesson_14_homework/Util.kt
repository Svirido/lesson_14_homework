package com.example.lesson_14_homework

class Util

fun Pizza.extension(): String {
    var info = "Пицца: ${this.name} \nЦена: ${this.price} руб."
    return info
}
