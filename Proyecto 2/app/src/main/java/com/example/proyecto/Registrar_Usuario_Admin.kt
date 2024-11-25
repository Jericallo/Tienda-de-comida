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

class Registrar_Usuario_Admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario_admin)

        val editTextCorreo: EditText = findViewById(R.id.editTextCorreo)
        val editTextContra: EditText = findViewById(R.id.editTextContra)
        val editTextIdentidad: EditText = findViewById(R.id.editTextIdentidad)
        val spinnerModerador: Spinner = findViewById(R.id.spinnerModerador)
        val editTextPhoto: EditText = findViewById(R.id.editTextPhoto)
        val buttonRegister: Button = findViewById(R.id.buttonRegister)
        val buttonBack: ImageButton = findViewById(R.id.buttonBack)
    //andres.arevalonavarro@gmail.com
        buttonRegister.setOnClickListener {
            var usuarioEncontrado = false
            val correo = editTextCorreo.text.toString()
            val contra = editTextContra.text.toString()
            val identidad = editTextIdentidad.text.toString()
            val moderador = spinnerModerador.selectedItem.toString() // Obtener el valor seleccionado del Spinner
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

                    // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
                    val intent2 = Intent(this, ListaUsuarios::class.java)

                    startActivity(intent2)
                    finish()
                }


            }


        }

        buttonBack.setOnClickListener {
            val intent = Intent(this, ListaUsuarios::class.java)
            startActivity(intent)
            finish() // Termina la actividad y regresa a la pantalla anterior
        }
    }
}