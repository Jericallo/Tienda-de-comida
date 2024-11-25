package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.R //Remplaza "recycleview" por el nombre de tu paquete

class ListaUsuarios : AppCompatActivity() {
    private lateinit var txtnombre: TextView

    private lateinit var recyclerView: RecyclerView
    private lateinit var usuariosAdapter: UsuariosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuarios)
        setUpRecycleView()

        txtnombre=findViewById(R.id.Presentacion)

        //andres.arevalonavarro@gmail.com



        for (usuario in usuarios) {
            if (usuario.correo == correo ) {
                txtnombre.text= "Bienvenido ${usuario.identidad}"
                break
            }
        }
        val button = findViewById<Button>(R.id.btn_cerrarsesion)
        button.setOnClickListener {
            // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val button2 = findViewById<Button>(R.id.btn_agregarusuario)
        button2.setOnClickListener {
            // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
            val intent = Intent(this, Registrar_Usuario_Admin::class.java)
            startActivity(intent)
        }
        val button3 = findViewById<Button>(R.id.btn_registroProductos)
        button3.setOnClickListener {
            // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
            val intent = Intent(this, ListaProductos::class.java)
            startActivity(intent)
        }



    }


    fun setUpRecycleView(){

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        usuariosAdapter = UsuariosAdapter(usuarios, this)
        recyclerView.adapter = usuariosAdapter
    }

   /* fun getSuperheroes(): MutableList<Usuarios>{

        val usuarios:MutableList<Usuarios> = mutableListOf()
        usuarios.add(Usuarios("andres.arevalonavarro@gmail.com", "12234", "Andres", "Admin","andres"))

        return usuarios
    }

    */
}