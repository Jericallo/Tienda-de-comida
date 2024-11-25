package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
val carrito:MutableList<Carrito> = mutableListOf()

class MainUsuario : AppCompatActivity() {
    private lateinit var txtnombre: TextView

    private lateinit var recyclerView: RecyclerView
    private lateinit var productosAdapterUsuarios: ProductosAdapterUsuarios

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_usuario)
        setUpRecycleView()

        txtnombre=findViewById(R.id.Presentacion0)

        //andres.arevalonavarro@gmail.com
        //salvador.arevalonavarro@gmail.com



        for (usuario in usuarios) {
            if (usuario.correo == correo ) {
                txtnombre.text= "Bienvenido ${usuario.identidad}"
                break
            }
        }
        val button = findViewById<Button>(R.id.btn_regresarProduvto)
        button.setOnClickListener {
            // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val button2 = findViewById<Button>(R.id.comprar)
        button2.setOnClickListener {
            // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
            val intent = Intent(this, Carritousuario::class.java)
            startActivity(intent)
        }




    }


    fun setUpRecycleView(){

        recyclerView = findViewById(R.id.carrito11)

        recyclerView.layoutManager = LinearLayoutManager(this)

        productosAdapterUsuarios =  ProductosAdapterUsuarios(productos, this)
        recyclerView.adapter = productosAdapterUsuarios
    }

}
