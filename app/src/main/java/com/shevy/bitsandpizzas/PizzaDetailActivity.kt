package com.shevy.bitsandpizzas

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class PizzaDetailActivity : AppCompatActivity() {
    companion object {
    val EXTRA_PIZZA_ID = "pizzaId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_detail)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        val pizzaId = intent.extras!![EXTRA_PIZZA_ID] as Int
        val pizzaName: String = Pizza.pizzas[pizzaId].name
        val textView = findViewById<View>(R.id.pizza_text) as TextView
        textView.text = pizzaName
        val pizzaImage: Int = Pizza.pizzas[pizzaId].imageResourceId
        val imageView = findViewById<View>(R.id.pizza_image) as ImageView
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pizzaImage))
        imageView.contentDescription = pizzaName
    }
}