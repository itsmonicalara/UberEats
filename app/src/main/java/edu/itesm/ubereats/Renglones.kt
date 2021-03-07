package edu.itesm.ubereats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_renglones.*
import java.time.LocalDateTime
import kotlin.random.Random

class Renglones : AppCompatActivity() {
    private lateinit var imcAdapter: OrdenAdapter
    private lateinit var medidas : ArrayList<OrdenInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_renglones)

        initRecycler()

    }

    fun initRecycler(){
        medidas = ArrayList<OrdenInfo>()
        imcAdapter = OrdenAdapter(medidas)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = imcAdapter
        for( i in 0..30){
            val fecha = LocalDateTime.now()
            val medida = OrdenInfo(fecha.toString())
            medidas.add(medida)
        }

    }



}