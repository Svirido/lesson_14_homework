package com.example.lesson_14_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.lesson_14_homework.databinding.ActivityMain2Binding
import com.example.lesson_14_homework.databinding.ActivityMainBinding

lateinit var binding2: ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        binding2 = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding2.root)
    }

    fun add(view: View) {
        binding2.textAdd.visibility = View.VISIBLE
        binding2.buttonBigFourCheeses.visibility = View.VISIBLE
        binding2.buttonBigNeapolitan.visibility = View.VISIBLE
        binding2.buttonSmallSicilian.visibility = View.VISIBLE
        binding2.buttonSmallMargarita.visibility = View.VISIBLE
    }

    fun closeAdd() {
        binding2.textAdd.visibility = View.INVISIBLE
        binding2.buttonBigFourCheeses.visibility = View.INVISIBLE
        binding2.buttonBigNeapolitan.visibility = View.INVISIBLE
        binding2.buttonSmallSicilian.visibility = View.INVISIBLE
        binding2.buttonSmallMargarita.visibility = View.INVISIBLE
    }

    fun addBigFourCheeses(view: View) {
        var pizzaBigFourCheeses = BigFourCheeses()
        pizzaBigFourCheeses.name = "Большая четыри сыра"
        pizzaBigFourCheeses.price = 30
        PizzaSingleton.pizza.add(pizzaBigFourCheeses)
        closeAdd()
    }

    fun addBigNeapolitan(view: View) {
        var pizzaBigNeapolitan = BigNeapolitan()
        pizzaBigNeapolitan.name = "Большая неаполитанская"
        pizzaBigNeapolitan.price = 25
        PizzaSingleton.pizza.add(pizzaBigNeapolitan)
        closeAdd()
    }

    fun addSmallSicilian(view: View) {
        var pizzaSmallSicilian = SmallSicilian()
        pizzaSmallSicilian.name = "Маленькая сицилийская"
        pizzaSmallSicilian.price = 18
        PizzaSingleton.pizza.add(pizzaSmallSicilian)
        closeAdd()
    }

    fun addSmallMargarita(view: View) {
        var pizzaSmallMargarita = SmallMargarita()
        pizzaSmallMargarita.name = "Маленькая маргарита"
        pizzaSmallMargarita.price = 14
        PizzaSingleton.pizza.add(pizzaSmallMargarita)
        closeAdd()
    }

    var counter = 0

    fun previous(view: View) {
        if (PizzaSingleton.pizza.firstOrNull() == null) {
            binding2.textViewOut.text = "Добавьте элемент"
        } else {
            if (counter <= 0) {
                counter = 0
            } else counter--
            binding2.textViewOut.text = PizzaSingleton.pizza[counter].extension()
            binding2.buttonDelete.visibility = View.VISIBLE
        }
    }

    fun next1(view: View) {
        if (PizzaSingleton.pizza.firstOrNull() == null) {
            binding2.textViewOut.text = "Добавьте элемент"
        } else {
            if (binding2.textViewOut.text == "") {
                binding2.textViewOut.text = PizzaSingleton.pizza[0].extension()
            } else
                if (PizzaSingleton.pizza.size - 1 == counter) {
                    binding2.textViewOut.text = PizzaSingleton.pizza[counter].extension()
                } else {
                    counter++
                    binding2.textViewOut.text = PizzaSingleton.pizza[counter].extension()
                }
            binding2.buttonDelete.visibility = View.VISIBLE
        }
    }

    fun delete(view: View) {
        if (PizzaSingleton.pizza.firstOrNull() != null) {
            PizzaSingleton.pizza.removeAt(counter)
            binding2.textViewOut.text = ""
            counter = 0
            binding2.buttonDelete.visibility = View.INVISIBLE
        }
    }

    fun gohomework14(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}