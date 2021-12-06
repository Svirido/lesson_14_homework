package com.example.lesson_14_homework

class Util


fun Pizza.extension() = "Пицца: ${this.name} \nЦена: ${this.price} руб."

fun BigFourCheeses.extension() =
    "Пицца: ${this.name} \nЦена: ${this.price} руб. \nРазмер: ${this.size} \nКоличество сыров ${this.numberOfCheeses}"

fun BigNeapolitan.extension() =
    "Пицца: ${this.name} \nЦена: ${this.price} руб. \nРазмер: ${this.size} \nСорт томатов ${this.tomatoVariety}"

fun SmallMargarita.extension() =
    "Пицца: ${this.name} \nЦена: ${this.price} руб. \nРазмер: ${this.size} \nКоличество базилика ${this.basil}"

fun SmallSicilian.extension() =
    "Пицца: ${this.name} \nЦена: ${this.price} руб. \nРазмер: ${this.size} \nВес ${this.weight}"

