package com.example.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.listaitem.view.*

class ListAdapter(
    private val listasList: MutableList<Lista>,
    private val listener: onItemClickListener
) : RecyclerView.Adapter<ListAdapter.ListaHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaHolder {
        return ListaHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.listaitem,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount() = listasList.size

    override fun onBindViewHolder(holder: ListaHolder, position: Int) {
        val currentItem = listasList[position]
        holder.itemView.apply {
            tvTitulo.text = currentItem.titulo
        }
    }

    inner class ListaHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onItemClick(adapterPosition)
        }
    }

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

}