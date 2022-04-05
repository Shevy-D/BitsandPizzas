package com.shevy.bitsandpizzas

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PizzaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pizzaRecycler: RecyclerView = inflater.inflate(
            R.layout.fragment_pizza, container, false
        ) as RecyclerView

        val pizzaNames = arrayOfNulls<String>(Pizza.pizzas.size)
        for (i in pizzaNames.indices) {
            pizzaNames[i] = Pizza.pizzas[i].name
        }

        val pizzaImages = IntArray(Pizza.pizzas.size)
        for (i in pizzaImages.indices) {
            pizzaImages[i] = Pizza.pizzas[i].imageResourceId
        }

        val adapter = CaptionedImagesAdapter(pizzaNames, pizzaImages)
        pizzaRecycler.adapter = adapter
        val layoutManager = GridLayoutManager(activity, 2)
        pizzaRecycler.layoutManager = layoutManager
        return pizzaRecycler

    }
}