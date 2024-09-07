package com.example.rertrofit.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rertrofit.R
import com.example.rertrofit.adapter.MyAdapter
import com.example.rertrofit.interfaces.ApiInterface
import com.example.rertrofit.model.MyData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recycleView:RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView = findViewById(R.id.recycleView)

        val retroFitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retroFitData = retroFitBuilder.getProductData()


        retroFitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
              //  api is run successful run and get data

                val responseBody = response.body()

                val productList = responseBody?.products!!

                if (productList == null) {
                    Toast.makeText(this@MainActivity, "Data not available", Toast.LENGTH_SHORT).show()
                }

                myAdapter = MyAdapter(this@MainActivity, productList)
                recycleView.adapter = myAdapter
                recycleView.layoutManager = LinearLayoutManager(this@MainActivity)

            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
               // api not get data
                Toast.makeText(this@MainActivity,"Not get data",Toast.LENGTH_SHORT).show()
            }
        })
    }
}