package com.example.recylerview


import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(
    private var heroList: Array<String?>?,
    private var realName: Array<String?>?,
    private var imageList: Array<String?>?
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var context: Context

    interface OnItemClicked {
        fun onClicked(position: Int)

    }
    // private lateinit var mListeners : OnItemClicked


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.singlerow, parent, false)
        context = parent.context
        return MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.cardName.text = heroList?.get(position)


        holder.cardRealName.text = realName?.get(position)

        Glide.with(context).load(imageList?.get(position)).centerCrop().into(holder.cardImage)

        imageList?.get(position)?.let { Log.d("Images", it) }

    }

    override fun getItemCount(): Int {
        return heroList?.size!!
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val cardName = itemView.findViewById<TextView>(R.id.text1)
        val cardRealName = itemView.findViewById<TextView>(R.id.text2)
        val cardImage = itemView.findViewById<ImageView>(R.id.img)

    }
}