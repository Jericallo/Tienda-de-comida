package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Carritousuario : AppCompatActivity() {
    private lateinit var txtnombre: TextView
    var total:Double=0.00
    private lateinit var recyclerView: RecyclerView
    private lateinit var carritoAdapterUsuario: CarritoAdapterUsuario
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_carritousuario)
        setUpRecycleView()
        txtnombre=findViewById(R.id.tituloRecyclerView011)


        //andres.arevalonavarro@gmail.com
        //salvador.arevalonavarro@gmail.com


        for (carritp in carrito) {
            total += carritp.precioTotal

        }
        txtnombre.text="TOTAl $ ${total}"

        val button = findViewById<Button>(R.id.btn_regresarProduvto)
        button.setOnClickListener {
            // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
            val intent = Intent(this, MainUsuario::class.java)
            startActivity(intent)
        }
        val button2 = findViewById<Button>(R.id.comprar)
        total=0.00
        button2.setOnClickListener {
            for (carritp in carrito) {
                total += carritp.precioTotal

            }
            txtnombre.text="TOTAl $ ${total}"

            Toast.makeText(this, "Comprado", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Total $total", Toast.LENGTH_SHORT).show()
            carrito.clear()
            carritoAdapterUsuario.notifyDataSetChanged()

        }





    }


    fun setUpRecycleView(){


        recyclerView = findViewById(R.id.carrito11)

        recyclerView.layoutManager = LinearLayoutManager(this)

        carritoAdapterUsuario =  CarritoAdapterUsuario(carrito, this)
        recyclerView.adapter = carritoAdapterUsuario

    }
}