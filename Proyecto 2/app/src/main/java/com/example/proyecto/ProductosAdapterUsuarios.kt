package com.example.proyecto
import android.app.AlertDialog
import android.util.Log
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.io.PrintStream


class ProductosAdapterUsuarios (
    var Productos: MutableList<Productos>,
    var context: Context
    ) : RecyclerView.Adapter<ProductosAdapterUsuarios.ViewHolder>() {

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = Productos[position]
            holder.bind(item, context, this)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return ViewHolder(layoutInflater.inflate(R.layout.item_productos_usuarios, parent, false))
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

            val nombre = view.findViewById(R.id.tvnombre22) as TextView
            val precio = view.findViewById(R.id.tvprecio22) as TextView
            val existencias = view.findViewById(R.id.tvExistencias22) as TextView
            val photo = view.findViewById(R.id.ivPhoto22) as ImageView
            val AgregarCarrito=view.findViewById(R.id.carrito22)as Button
            val editTextNCantidad = view.findViewById(R.id.CantidadAcomprar) as TextView


            fun bind(productos: Productos, context: Context, adapter: ProductosAdapterUsuarios) {
                nombre.text = productos.Nombre
                precio.text = "Precio $ ${productos.precio.toString()}"
                existencias.text = "Existencias: ${productos.existencias.toString()}"

                //presentacion
                // Ayuda
                val resourceId = context.resources.getIdentifier(productos.photo, "drawable", context.packageName)
                photo.setImageResource(resourceId)
                itemView.setOnClickListener { Toast.makeText(context, productos.Nombre, Toast.LENGTH_SHORT).show() }


                //BOTON DE Agregar USUARIO
                AgregarCarrito.setOnClickListener {
                    val CantidadAcomprar = editTextNCantidad.text.toString()

                    if(productos.existencias>0){
                        if(CantidadAcomprar.isEmpty() ){
                            Toast.makeText(context, "Primero dime la cantidad", Toast.LENGTH_SHORT).show()

                        }else{
                            if(CantidadAcomprar.toInt() > productos.existencias){
                                Toast.makeText(context, "Ingresaste la cantidad mayor de lo que hay", Toast.LENGTH_SHORT).show()
                            }else{
                                var Total=CantidadAcomprar.toInt()*productos.precio
                                carrito.add(Carrito(productos.Nombre, CantidadAcomprar.toInt(), Total, correo,productos.photo))
                                Toast.makeText(context, "Agregado", Toast.LENGTH_SHORT).show()
                                productos.existencias -= CantidadAcomprar.toInt()
                                adapter.notifyItemChanged(adapterPosition)
                                println("aaaaa")

                                Log.d("MiEtiqueta", productos.toString())
                            }

                        }

                    }else{
                        Toast.makeText(context, "No hay existencias", Toast.LENGTH_SHORT).show()
                    }
                }



            }

        }

    }

