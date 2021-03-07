package edu.itesm.ubereats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrdenAdapter(private val medidas : List<OrdenInfo>) : RecyclerView.Adapter<OrdenAdapter.ImcViewHolder>(){

    inner class ImcViewHolder(renglon: View) : RecyclerView.ViewHolder(renglon){
        var fecha = renglon.findViewById<TextView>(R.id.fechaText)
    }

    //Crea el renglón
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImcViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val renglon_vista = inflater.inflate(R.layout.renglon_layout,parent, false)
        return ImcViewHolder(renglon_vista)
    }

    //Asocia datos con los elementos del renglón
    override fun onBindViewHolder(holder: ImcViewHolder, position: Int) {
        val dato = medidas[position]
        holder.fecha.text = dato.fecha
    }

    // Cuantos elementos tiene la lista
    override fun getItemCount(): Int {
        return medidas.size
    }
}