package com.shevy.bitsandpizzas

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class PastaFragment : ListFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adapter = ArrayAdapter(
            inflater.context,
            android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.pasta)
        )
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}