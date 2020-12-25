package com.example.inventoryapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.inventoryapp.Object.Item
import com.example.inventoryapp.R
import com.squareup.picasso.Picasso

class ItemAdapter(contexts: FragmentActivity?, item: ArrayList<Item>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    //declare a context
    var context: FragmentActivity? = contexts
    // Cached copy of user
    private var items = item

    //to hold one single view only
    inner class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
          val img: ImageView = itemView.findViewById(R.id.imageView)
          val name: TextView = itemView.findViewById(R.id.item)
          val stock: TextView = itemView.findViewById(R.id.itemstock)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_inventory,parent,false)
        return ItemViewHolder(itemView)
    }

    override fun getItemCount() = items.size

//    internal fun setItems(items: List<Item>) {
//        this.items = items
//        notifyDataSetChanged()
//    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //getting the current item
        val currentItem = items[position]


        //load img of the current item using picasso
        Picasso.with(context).load(currentItem.img).into(holder.img)
//        Picasso.get().load(url).into(imageView)

        //load the item and item stock
        holder.name.text = currentItem.name
        holder.stock.text = holder.stock.text.toString() + " " + currentItem.qty.toString() + " " + currentItem.unit

    }
}