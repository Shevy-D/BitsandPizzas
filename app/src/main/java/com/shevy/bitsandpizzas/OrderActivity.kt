package com.shevy.bitsandpizzas

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val toolbar = findViewById<View>(R.id.toolbar) as android.support.v7.widget.Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun onClickDone(view: View) {
        val text: String = "Your order has been updated"
        val duration: Int = Snackbar.LENGTH_SHORT
        val snackbar: Snackbar = Snackbar.make(findViewById(R.id.coordinator), text, duration)
        snackbar.setAction("Undo", View.OnClickListener() {
            fun onClick(view: View) {
                val toast = Toast.makeText(this, "Undone!", Toast.LENGTH_LONG)
                toast.show()
            }
        })
        snackbar.show()
    }
}