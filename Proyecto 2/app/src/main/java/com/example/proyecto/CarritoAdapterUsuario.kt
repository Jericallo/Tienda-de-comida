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

class CarritoAdapterUsuario(
var carritos: MutableList<Carrito>,
var context: Context
) : RecyclerView.Adapter<CarritoAdapterUsuario.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = carritos[position]
        holder.bind(item, context, this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_carrito_usuarios, parent, false))
    }

    override fun getItemCount(): Int {
        return carritos.size
    }
    fun removeItem(position: Int) {

        carritos.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, carritos.size)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nombre = view.findViewById(R.id.tvnombre2) as TextView
        val Cantidadtotal = view.findViewById(R.id.tvCantidadtotal) as TextView
        val Precio = view.findViewById(R.id.tvprecio) as TextView
        val photo = view.findViewById(R.id.foto1) as ImageView
        val eliminarCarrito=view.findViewById(R.id.EliminarCarrito)as Button
        val persona = view.findViewById(R.id.tvUsuario) as TextView


        fun bind(carritos: Carrito, context: Context, adapter: CarritoAdapterUsuario) {
            nombre.text = carritos.Nombre
            Cantidadtotal.text = "Ordenes pedidos: ${carritos.cantidad.toString()}"
            Precio.text = "Precio total $ ${carritos.precioTotal.toString()}"
            persona.text=carritos.Persona


            //presentacion
            // Ayuda
            val resourceId = context.resources.getIdentifier(carritos.photo, "drawable", context.packageName)
            photo.setImageResource(resourceId)
            itemView.setOnClickListener { Toast.makeText(context, carritos.Nombre, Toast.LENGTH_SHORT).show() }


            //BOTON DE ELIMINAR USUARIO
            eliminarCarrito.setOnClickListener{
                AlertDialog.Builder(context) // Usamos `this` directamente
                    .setTitle("Confirmación")
                    .setMessage("¿Estás seguro de que deseas eliminar?")
                    .setPositiveButton("Sí") { dialog, which ->
                        // Aquí puedes iniciar la actividad correspondiente al inicio de sesión exitoso
                        for (productos in productos) {
                            if(productos.Nombre==carritos.Nombre){
                                productos.existencias+=carritos.cantidad
                            }

                        }
                        adapter.removeItem(adapterPosition)
                        adapter.notifyItemChanged(adapterPosition)



                    }
                    .setNegativeButton("No", null)
                    .show()
            }



        }

    }

}