package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registrar_Producto_Admin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_producto_admin)

        val editTextNombre: EditText = findViewById(R.id.editTextproducto)
        val editTextPrecio: EditText = findViewById(R.id.editTextContra2)
        val editTextExistencias: EditText = findViewById(R.id.editTextIdentidad2)
        val editTextPhoto: EditText = findViewById(R.id.editTextPhoto2)
        val buttonRegister: Button = findViewById(R.id.buttonRegister2)

        val buttonBack: ImageButton = findViewById(R.id.buttonBack2)
        //andres.arevalonavarro@gmail.com
        buttonRegister.setOnClickListener {
            var usuarioEncontrado = false
            val nombre = editTextNombre.text.toString()
            val precio = editTextPrecio.text.toString()
            val existencias = editTextExistencias.text.toString()
            val photo = editTextPhoto.text.toString()
            if (nombre.isEmpty() || precio.isEmpty() || existencias.isEmpty()  || photo.isEmpty()) {
                // Aquí puedes mostrar un mensaje de error o hacer alguna acción si algún campo está vacío
                Toast.makeText(this, "Todos los campos deben ser completados", Toast.LENGTH_SHORT).show()
            } else{


                for (producto in productos) {
                    if (producto.Nombre == nombre ){
                        Toast.makeText(this, "ERROR EL PRODUCTO YA ESTA REGISTRADO", Toast.LENGTH_SHORT).show()
                        usuarioEncontrado = true
                        break
                    }
                }
                if(usuarioEncontrado==false){

                    // Aquí puedes añadir la lógica para manejar los datos ingresados, como guardarlos en una base de datos
                    productos.add(Productos(nombre, precio.toDouble(), existencias.toInt(),photo))

                    // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
                    val intent2 = Intent(this, ListaProductos::class.java)

                    startActivity(intent2)
                    finish()
                }


            }


        }

        buttonBack.setOnClickListener {
            val intent = Intent(this, ListaProductos::class.java)
            startActivity(intent)
            finish() // Termina la actividad y regresa a la pantalla anterior
        }
    }
}