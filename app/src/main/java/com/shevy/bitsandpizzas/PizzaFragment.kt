package com.shevy.bitsandpizzas

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PizzaFragment : Fragment() {
/*    val EXTRA_PIZZA_ID = "pizzaId"*/

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

        adapter.setListener(object : CaptionedImagesAdapter.Listener {
            override fun onClick(position: Int) {
                val intent = Intent(activity, PizzaDetailActivity::class.java)
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZA_ID, position)
                activity!!.startActivity(intent)
            }
        })
        return pizzaRecycler
    }
}