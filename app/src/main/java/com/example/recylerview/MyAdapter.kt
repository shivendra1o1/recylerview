package com.example.recylerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View


import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val arrayList: ArrayList<Model>, val context: Context) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.singlerow, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int {

            return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binditem(arrayList[position])
    }
    class ViewHolder(itemView: View  ):RecyclerView.ViewHolder(itemView){
        fun binditem(model: Model){
            val text1 = itemView.findViewById<TextView>(R.id.text1)
            val text2 = itemView.findViewById<TextView>(R.id.text2)
            val img=itemView.findViewById<ImageView>(R.id.img)
            text1.text=model.title



        }
    }

}