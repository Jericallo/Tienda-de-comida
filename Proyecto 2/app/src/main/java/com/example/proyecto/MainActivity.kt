package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.R //Remplaza "recycleview" por el nombre de tu paquete
val usuarios:MutableList<Usuarios> = mutableListOf()
val productos:MutableList<Productos> = mutableListOf()

var correo:String = ""


class MainActivity : AppCompatActivity() {

    private lateinit var etn1:EditText
    private lateinit var etn2:EditText
 //Imprexiones   private lateinit var recyclerView: RecyclerView
  //Impreciones  private lateinit var UsuariosAdapter: UsuariosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Inicializaremos una cuenta por defauñt
        var cont:Int =0
        for (usuario in usuarios) {
            if (usuario.correo == "andres.arevalonavarro@gmail.com" ) {
                cont++
                break
            }
        }
        if(cont==0){
            productos.add(Productos("Alitas", 100.00, 10, "alitas"))
            productos.add(Productos("Boneles", 95.00, 12, "boneles"))
            productos.add(Productos("pagas gajo", 95.00, 12, "papasgajo"))

            usuarios.add(Usuarios("andres.arevalonavarro@gmail.com", "12234", "Andres", "Admin","andres"))
            usuarios.add(Usuarios("andres.arevalonavarro@gmail.com", "12234", "Andres", "Admin","si"))
            usuarios.add(Usuarios("salvador.arevalonavarro@gmail.com", "1", "Salvador", "Usuario","salvador"))
       //     usuarios.add(Usuarios("carlos.albertopacheco@gmail.com", "1", "Carlos", "Usuario","carlos"))
        //    usuarios.add(Usuarios("yuki.hino@gmail.com", "1", "Yuki", "Usuario","yuki"))

        }

        etn1=findViewById(R.id.email_etn)
        etn2=findViewById(R.id.contea_etn)
        val button = findViewById<Button>(R.id.Btn_registro)
        val button2 = findViewById<Button>(R.id.Btn_iniciarseccion)
        val button3 = findViewById<Button>(R.id.Btn_registro)
        button.setOnClickListener {
            // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
            }
        button3.setOnClickListener {
            // Aquí puedes agregar la lógica que deseas ejecutar al hacer clic en el botón
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }



        button2.setOnClickListener {
            val emailIngresado = etn1.text.toString()
            val contrasenaIngresada = etn2.text.toString()



            var usuarioEncontrado = false
            for (usuario in usuarios) {
                if (usuario.correo == emailIngresado && usuario.contra == contrasenaIngresada) {
                    usuarioEncontrado = true
                    correo=usuario.correo // guarda un correo en la puclica
                    if(usuario.moderador=="Admin"){
                        // Aquí puedes iniciar la actividad correspondiente al inicio de sesión exitoso
                        val intent = Intent(this, ListaUsuarios::class.java) //Reemplaza "PantallaPrincipal" con el nombre de tu actividad
                        startActivity(intent)
                        break
                    }else{
                        // Aquí puedes iniciar la actividad correspondiente al inicio de sesión exitoso
                        val intent2 = Intent(this, MainUsuario::class.java) //Reemplaza "PantallaPrincipal" con el nombre de tu actividad
                        startActivity(intent2)
                        break
                    }


                }
            }

            if (!usuarioEncontrado) {
                // Aquí puedes mostrar un mensaje de error al usuario
                Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }


    }
    //RECIBIR PARAMETROS DE LOS DATOS DE LOS USUARIOS
  //  fun getSuperheroes(): MutableList<Usuarios>{
    //    usuarios.add(Usuarios("andres.arevalonavarro@gmail.com", "12234", "Andres", "Admin","andres"))

      //  return usuarios
    //}

}

