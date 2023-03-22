package com.example.recylerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arrayList=ArrayList<Model>()
        arrayList.add(Model("news","this is news feed",R.drawable.ic_launcher_background))
        arrayList.add(Model("news","this is news feed",R.drawable.ic_launcher_background))
        arrayList.add(Model("news","this is news feed",R.drawable.ic_launcher_foreground))
        arrayList.add(Model("news","this is news feed",R.drawable.ic_launcher_background))
        arrayList.add(Model("news","this is news feed",R.drawable.ic_launcher_foreground))
        arrayList.add(Model("news","this is news feed",R.drawable.ic_launcher_background))
        arrayList.add(Model("news","this is news feed",R.drawable.ic_launcher_background))
        arrayList.add(Model("news","this is news feed",R.drawable.ic_launcher_foreground))
        arrayList.add(Model("news","this is news feed",R.drawable.ic_launcher_background))
        arrayList.add(Model("news","this is news feed",R.drawable.ic_launcher_foreground))
        val myAdapter=MyAdapter(arrayList,this)
        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recview)

        // Use a linear layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter=myAdapter

        // Create an adapter and set it on the RecyclerView

    }
}


