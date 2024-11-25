package com.example.proyecto

import android.app.AlertDialog

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto.R //Remplaza "recycleview" por el nombre de tu paquete


class UsuariosAdapter(
    var Cuentas: MutableList<Usuarios>,
    var context: Context
) : RecyclerView.Adapter<UsuariosAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = Cuentas[position]
        holder.bind(item, context, this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_cuenta, parent, false))
    }

    override fun getItemCount(): Int {
        return Cuentas.size
    }
    fun removeItem(position: Int) {
        Cuentas.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, Cuentas.size)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nombre = view.findViewById(R.id.tvnombre) as TextView
        val correo = view.findViewById(R.id.tvCorreo) as TextView
        val contra = view.findViewById(R.id.tvContrase) as TextView
        val tipo = view.findViewById(R.id.tvTipo) as TextView
        val photo = view.findViewById(R.id.ivPhoto) as ImageView
        val btneliminar=view.findViewById(R.id.btnEliminar)as Button

        fun bind(cuentas: Usuarios, context: Context,adapter: UsuariosAdapter) {
            nombre.text = cuentas.identidad
            correo.text = cuentas.correo
            contra.text = cuentas.contra
            tipo.text = cuentas.moderador
            //presentacion
            // Ayuda
            val resourceId = context.resources.getIdentifier(cuentas.photo, "drawable", context.packageName)
            photo.setImageResource(resourceId)
            itemView.setOnClickListener { Toast.makeText(context, cuentas.identidad, Toast.LENGTH_SHORT).show() }

            //BOTON DE ELIMINAR USUARIO
            btneliminar.setOnClickListener{
                AlertDialog.Builder(context) // Usamos `this` directamente
                    .setTitle("Confirmación")
                    .setMessage("¿Estás seguro de que deseas eliminar?")
                    .setPositiveButton("Sí") { dialog, which ->
                        // Aquí puedes iniciar la actividad correspondiente al inicio de sesión exitoso
                        adapter.removeItem(adapterPosition)

                    }
                    .setNegativeButton("No", null)
                    .show()
            }



        }

    }
}
