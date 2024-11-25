package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)

        val editTextCorreo: EditText = findViewById(R.id.editTextCorreo11)
        val editTextContra: EditText = findViewById(R.id.editTextContra11)
        val editTextIdentidad: EditText = findViewById(R.id.editTextIdentidad11)
        val editTextPhoto: EditText = findViewById(R.id.editTextPhoto11)
        val buttonRegister: Button = findViewById(R.id.buttonRegister11)
        val buttonBack: ImageButton = findViewById(R.id.buttonBack11)
        //andres.arevalonavarro@gmail.com
        buttonRegister.setOnClickListener {
            var usuarioEncontrado = false
            val correo = editTextCorreo.text.toString()
            val contra = editTextContra.text.toString()
            val identidad = editTextIdentidad.text.toString()
            val moderador = "Usuario"
            val photo = editTextPhoto.text.toString()
            if (correo.isEmpty() || contra.isEmpty() || identidad.isEmpty() || moderador.isEmpty() || photo.isEmpty()) {
                // Aquí puedes mostrar un mensaje de error o hacer alguna acción si algún campo está vacío
                Toast.makeText(this, "Todos los campos deben ser completados", Toast.LENGTH_SHORT).show()
            } else if (!correo.endsWith("@gmail.com")) {
                Toast.makeText(this, "el correo es invalido", Toast.LENGTH_SHORT).show()

            }else{


                for (usuario in usuarios) {
                    if (usuario.correo == correo ){
                        Toast.makeText(this, "ERROR EL CORREO YA ESTA REGISTRADO", Toast.LENGTH_SHORT).show()
                        usuarioEncontrado = true
                        break
                    }
                }
                if(usuarioEncontrado==false){

                    // Aquí puedes añadir la lógica para manejar los datos ingresados, como guardarlos en una base de datos
                    usuarios.add(Usuarios(correo, contra, identidad, moderador,photo))
                    Toast.makeText(this, "Registrado :D", Toast.LENGTH_SHORT).show()
                    // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
                    val intent2 = Intent(this, MainActivity::class.java)

                    startActivity(intent2)
                    finish()
                }


            }


        }

        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Termina la actividad y regresa a la pantalla anterior
        }
    }
}