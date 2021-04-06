package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , ListAdapter.onItemClickListener{
    private lateinit var listAdapter:ListAdapter
    private var listasList = mutableListOf<Lista>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listAdapter = ListAdapter(listasList, this )
        rvListas.adapter = listAdapter
        rvListas.layoutManager = LinearLayoutManager(this)

        btnNewList.setOnClickListener {
            val str = etNewList.text.toString()
            if (str.isNotEmpty()){
                val lista = Lista(listasList.size, str)
                addElementToList(lista)
                etNewList.text.clear()
            }
        }
    }

    fun addElementToList(lista: Lista){
        listasList.add(lista)
        listAdapter.notifyItemInserted(listasList.size-1)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Lista clickeada: ${listasList[position].titulo}", Toast.LENGTH_SHORT).show()
    }
}