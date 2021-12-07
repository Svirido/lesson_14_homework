package com.example.lesson_14_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lesson_14_homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textOutput.setText(R.string.title)
        binding.textOutput2.visibility = View.INVISIBLE
    }

    // 1. Вывести первые 20 чисел ряда фибоначчи циклом и рекурсией
    // циклом
    fun fibonacciCycle(view: View) {
        val fib = Array(20) { 0 }
        fib[1] = 1
        var i = 2
        while (i in fib.indices) {
            fib[i] = fib[i - 1] + fib[i - 2]
            i++
            binding.textOutput.setText(R.string.info11)
            binding.textOutput2.visibility = View.VISIBLE
            binding.textOutput2.text = fib.contentToString()
        }
    }

    // рекурсией
    fun fibonacciRecursion(view: View) {
        val fib2 = Array(20) { 0 }
        var i = 0
        while (i in fib2.indices) {
            fib2[i] = fibonacci(i)
            i++
            binding.textOutput.setText(R.string.info12)
            binding.textOutput2.visibility = View.VISIBLE
            binding.textOutput2.text = fib2.contentToString()
        }
    }

    fun fibonacci(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        else return fibonacci(n - 1) + fibonacci(n - 2)
    }

    /* 2. Создать data класс с 2 полями типа int и 5 любыми полями.
    Сделать функцию для генерации объекта data класса рандомными числами. */
    data class Class1(
        val a1: Int,
        val a2: Int,
        val b1: Int,
        val b2: Int,
        val b3: Int,
        val b4: Int,
        val b5: Int,
    )
    fun random(): Int {
        return (0..10).random()
    }

    val class1 = Class1(random(), random(), random(), random(), random(), random(), random())
    fun random(view: View) {
        binding.textOutput.setText(R.string.info2)
        binding.textOutput2.visibility = View.VISIBLE
        binding.textOutput2.text = class1.toString()
    }

    // 3. Создать класс наследник от data класса
    fun copy(view: View) {
        val class2 = class1.copy()
        binding.textOutput.setText(R.string.info3)
        binding.textOutput2.visibility = View.VISIBLE
        binding.textOutput2.text = class2.toString()
    }

    /* 4. Сделать класс ‘Util’ который будет содержать в себе поля типа класса наследника и метод
    который будет считать и возвращать сумму полей data class */

    class Util {
        var class2 = Class1(10, 8, 9, 1, 2, 6, 8)

        inner class Iner {
            var sum =
                class2.a1 + class2.a2 + class2.b1 + class2.b2 + class2.b3 + class2.b4 + class2.b5
        }
    }

    fun print4(view: View) {
        binding.textOutput.setText(R.string.info4)
        binding.textOutput2.visibility = View.VISIBLE
        binding.textOutput2.text = Util().Iner().sum.toString()
    }

    /* 5. Создать файл kotlin в котором необходимо написать функцию расширения для data класса
    считающую и возвращающую сумму полей data class */

    fun print5(view: View) {
        binding.textOutput.setText(R.string.info5)
        binding.textOutput2.visibility = View.VISIBLE
        binding.textOutput2.text = class3.enlargement().toString()
    }

    /* 6. * В главном окне приложения добавить кнопку и текстовое поле.
    по нажатию на кнопку в текстовое поле выводить количество нажатий */

    var counter = 0
    fun counter(view: View) {
        counter++
        binding.textOutput.setText(R.string.info6)
        binding.textOutput2.visibility = View.VISIBLE
        binding.textOutput2.text = counter.toString()
    }

    /* 7. * В главном окне приложения добавить ещё одну кнопку и текстовые поля, по нажатию на
    кнопку необходимо генерировать объект data класса и все имеющиеся поля класса выводить
    в текстовое поле. По каждому нажатию необходимо сгенерировать и отобразить новый объект. */

    fun newdata(view: View) {
        val class4 = Class1(random(), random(), random(), random(), random(), random(), random())
        binding.textOutput.setText(R.string.info7)
        binding.textOutput2.visibility = View.VISIBLE
        binding.textOutput2.text = class4.toString()
    }

    fun gohomework15(view: View){
        startActivity(
            Intent(this, MainActivity2::class.java)
        )
    }
}


