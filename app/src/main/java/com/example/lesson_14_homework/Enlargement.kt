package com.example.lesson_14_homework

/* 5. Создать файл kotlin в котором необходимо написать функцию расширения для data класса
считающую и возвращающую сумму полей data class */

fun MainActivity.Class1.enlargement() : Int{
    val enlargementSum = this.a1 + this.a2 + this.b1 + this.b2 + this.b3 + this.b4 + this.b5
    return enlargementSum
}

var class3 = MainActivity.Class1(9, 12, 7, 6, 8, 7, 2)



