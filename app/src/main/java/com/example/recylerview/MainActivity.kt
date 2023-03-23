package com.example.recylerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var ListItems: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recview)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val okhttpClient: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()
        val gson: Gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://simplifiedcoding.net/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okhttpClient)
            .build()
        val api = retrofit.create(ApiInterface::class.java)
        api.getHeros().enqueue(object : Callback<List<Heros>> {
            override fun onResponse(call: Call<List<Heros>>, response: Response<List<Heros>>) {
                Log.d("Success1", "Data fetched")

                val heroList: List<Heros>? = response.body()
                Log.d("herolist", heroList.toString())
                val heroesName = heroList?.let { arrayOfNulls<String>(it.size) }
                val realName = heroList?.let { arrayOfNulls<String>(it.size) }
                val heroImage = heroList?.let { arrayOfNulls<String>(it.size) }
                ListItems = ArrayList<String>()

                for (i in heroList!!.indices) {
                    heroesName?.set(i, heroList[i].name)
                    realName?.set(i, heroList[i].realname)
                    heroImage?.set(i, heroList[i].imageurl)


                    val adapter = MyAdapter(heroesName, realName, heroImage)
                    heroImage?.get(i)?.let { Log.d("heroImage", it) }
                    recyclerView.adapter = adapter



                    adapter.notifyDataSetChanged()


                    // Thread.sleep(2000)
                }


            }

            override fun onFailure(call: Call<List<Heros>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                Log.d("error1", t.message.toString())
            }

        })


    }
}