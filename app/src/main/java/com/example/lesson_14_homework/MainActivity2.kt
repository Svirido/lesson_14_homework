package com.example.lesson_14_homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.lesson_14_homework.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding2: ActivityMain2Binding
    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        binding2 = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding2.root)

        var box = Catalog<Pizza>()

        var pizza1 = Pizza()
        box.boxPizza.add(pizza1.apply {
            name = "Четыре сезона"
            price = 23
        })
        binding2.textViewCatalog0.text = box.boxPizza[0].extension()

        var pizza2 = Pizza()
        box.boxPizza.add(pizza2.apply {
            name = "Маргарита"
            price = 19
        })
        binding2.textViewCatalog1.text = box.boxPizza[1].extension()

        var pizza3 = Pizza()
        box.boxPizza.add(pizza3.apply {
            name = "Карбонара"
            price = 27
        })
        binding2.textViewCatalog2.text = box.boxPizza[2].extension()

        var i = 0
        val button: Button = findViewById(R.id.buttonAdd)
        button.setOnClickListener {
            i++
            when (i) {
                1 -> {
                    PizzaSingleton.pizza.add(box.boxPizza[0])
                    binding2.textViewSingelton0.text = PizzaSingleton.pizza[0].extension()
                }
                2 -> {
                    PizzaSingleton.pizza.add(box.boxPizza[1])
                    binding2.textViewSingelton1.text = PizzaSingleton.pizza[1].extension()
                }
                else -> {
                    PizzaSingleton.pizza.add(box.boxPizza[2])
                    binding2.textViewSingelton2.text = PizzaSingleton.pizza[2].extension()
                }
            }
        }
    }


    var counter = 0

//    fun add(view: View) {
//        binding2.run {
//            textAdd.visibility = View.VISIBLE
//            buttonBigFourCheeses.visibility = View.VISIBLE
//            buttonBigNeapolitan.visibility = View.VISIBLE
//            buttonSmallSicilian.visibility = View.VISIBLE
//            buttonSmallMargarita.visibility = View.VISIBLE
//        }
//    }

    fun closeAdd() {
        binding2.run {
            textAdd.visibility = View.INVISIBLE
            buttonBigFourCheeses.visibility = View.INVISIBLE
            buttonBigNeapolitan.visibility = View.INVISIBLE
            buttonSmallSicilian.visibility = View.INVISIBLE
            buttonSmallMargarita.visibility = View.INVISIBLE
        }
    }

    fun addBigFourCheeses(view: View) {
        PizzaSingleton.pizza.add(
            BigFourCheeses().apply {
                name = "Большая четыри сыра"
                price = 30
                size = 4
                numberOfCheeses = 4
            }
        )
        closeAdd()
    }

    fun addBigNeapolitan(view: View) {
        PizzaSingleton.pizza.add(
            BigNeapolitan().apply {
                name = "Большая неаполитанская"
                price = 25
            }
        )
        closeAdd()
    }

    fun addSmallSicilian(view: View) {
        PizzaSingleton.pizza.add(
            SmallSicilian().apply {
                name = "Маленькая сицилийская"
                price = 18
            }
        )
        closeAdd()
    }

    fun addSmallMargarita(view: View) {
        PizzaSingleton.pizza.add(
            SmallMargarita().apply {
                name = "Маленькая маргарита"
                price = 14
            }
        )
        closeAdd()
    }

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
        when {
            PizzaSingleton.pizza.firstOrNull() == null -> binding2.textViewOut.text =
                "Добавьте элемент"
            binding2.textViewOut.text == "" -> binding2.textViewOut.text =
                PizzaSingleton.pizza[0].extension()
            PizzaSingleton.pizza.size - 1 == counter -> binding2.textViewOut.text =
                PizzaSingleton.pizza[counter].extension()
            else -> {
                counter++
                binding2.textViewOut.text = PizzaSingleton.pizza[counter].extension()
            }
        }
        binding2.buttonDelete.visibility = View.VISIBLE
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
        startActivity(
            Intent(this, MainActivity::class.java)
        )
    }
}