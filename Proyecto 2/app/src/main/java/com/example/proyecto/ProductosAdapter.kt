package com.example.proyecto

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class ProductosAdapter(
var Productos: MutableList<Productos>,
var context: Context
) : RecyclerView.Adapter<ProductosAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = Productos[position]
        holder.bind(item, context, this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_productos, parent, false))
    }

    override fun getItemCount(): Int {
        return Productos.size
    }
    fun removeItem(position: Int) {
        Productos.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, Productos.size)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nombre = view.findViewById(R.id.tvnombre2) as TextView
        val precio = view.findViewById(R.id.tvprecio) as TextView
        val existencias = view.findViewById(R.id.tvExistencias) as TextView
        val photo = view.findViewById(R.id.ivPhoto2) as ImageView
        val btneliminar=view.findViewById(R.id.carrito)as Button

        fun bind(productos: Productos, context: Context, adapter: ProductosAdapter) {
            nombre.text = productos.Nombre
            precio.text = productos.precio.toString()
            existencias.text = productos.existencias.toString()

            //presentacion
            // Ayuda
            val resourceId = context.resources.getIdentifier(productos.photo, "drawable", context.packageName)
            photo.setImageResource(resourceId)
            itemView.setOnClickListener { Toast.makeText(context, productos.Nombre, Toast.LENGTH_SHORT).show() }

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
