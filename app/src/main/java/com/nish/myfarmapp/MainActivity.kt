package com.nish.myfarmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /**call a coroutine scope, make it to the background thread then launch the coroutine*/
        CoroutineScope(Dispatchers.IO).launch {
            /**make a request call*/
            val retrofit = RetrofitInstance()
            /**call for our service*/
            val service = retrofit.initialServices()
            /**for picking our animals from the retrofit*/
            val animals  = service.getAnimals().response

            /**loading our objects into our UI, here we need to change from IO thread to Main thread*/
            withContext(Dispatchers.Main) {
             /**call the recycler view*/
                val recyclerView =findViewById<RecyclerView>(R.id.my_view)
                /**call our adapter*/
                val adapter = AnimalAdapter(this@MainActivity, animals)
                /**attach recyclerView to adapter*/
                recyclerView.adapter = adapter
                /**attach recyclerView to layout manager*/
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

            }
        }
    }
}