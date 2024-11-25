package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaProductos : AppCompatActivity() {
    private lateinit var txtnombre: TextView

    private lateinit var recyclerView: RecyclerView
    private lateinit var productosAdapter: ProductosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_productos)
        setUpRecycleView()

        txtnombre=findViewById(R.id.Presentacion2)

        //andres.arevalonavarro@gmail.com
        //Inicializaremos un producto
        var cont:Int =0
        for (producto in productos) {
            if (producto.Nombre == "Alitas" ) {
                cont++
                break
            }
        }
        if(cont==0){
            productos.add(Productos("Alitas", 100.00, 10, "alitas"))

        }


        for (usuario in usuarios) {
            if (usuario.correo == correo ) {
                txtnombre.text= "Bienvenido ${usuario.identidad}"
                break
            }
        }
        val button = findViewById<Button>(R.id.btn_cerrarsesion2)
        button.setOnClickListener {
            // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val button2 = findViewById<Button>(R.id.btn_agregarusuario2)
        button2.setOnClickListener {
            // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
            val intent = Intent(this, Registrar_Producto_Admin::class.java)
            startActivity(intent)
        }
        val button3 = findViewById<ImageButton>(R.id.buttonBack3)
        button3.setOnClickListener {
            // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
            val intent = Intent(this, ListaUsuarios::class.java)
            startActivity(intent)
        }



    }


    fun setUpRecycleView(){

        recyclerView = findViewById(R.id.recyclerView2)
        recyclerView.layoutManager = LinearLayoutManager(this)
        productosAdapter =  ProductosAdapter(productos, this)
        recyclerView.adapter = productosAdapter
    }

    /* fun getSuperheroes(): MutableList<Usuarios>{

         val usuarios:MutableList<Usuarios> = mutableListOf()
         usuarios.add(Usuarios("andres.arevalonavarro@gmail.com", "12234", "Andres", "Admin","andres"))

         return usuarios
     }

     */
}